import com.project.bean.*;
import com.project.dao.DomainsDAO;
import com.project.utils.SessionUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class InitializeDB {

    public static void main(String[] args) {

        Session session = new SessionUtil().getSession();
        session.beginTransaction();

        Departments department = new Departments("admin", 50);
        Employees employee1 = new Employees("emp1", "emp1@mail.com");
        Employees employee2 = new Employees("emp2", "emp2@mail.com");

        employee1.setDepartment(department);
        employee2.setDepartment(department);

        session.save(department);
        session.save(employee1);
        session.save(employee2);

        Domains domain1 = new Domains("M.Tech.(CSE)",2020,160);
        Domains domain2 = new Domains("iM.Tech.(CSE)", 2021, 100);

        session.save(domain1);
        session.save(domain2);

        Courses course1 = new Courses("C-1", "course1", 2000, 1, 4, 50);
        Courses course2 = new Courses("C-2", "course2", 2001, 2, 4, 50);

        session.save(course1);
        session.save(course2);

        CourseDomain courseDomain1 = new CourseDomain(domain1, course1);
        CourseDomain courseDomain2 = new CourseDomain(domain1, course2);

        session.save(courseDomain1);
        session.save(courseDomain2);

        Courses course3 = new Courses("C-3", "course3", 2001, 1, 4, 50);
        Courses course4 = new Courses("C-4", "course4", 2002, 2, 4, 50);
        Courses course5 = new Courses("C-5", "course5", 2003, 3, 4, 50);

        session.save(course3);
        session.save(course4);
        session.save(course5);

        CourseDomain courseDomain3 = new CourseDomain(domain2, course3);
        CourseDomain courseDomain4 = new CourseDomain(domain2, course4);
        CourseDomain courseDomain5 = new CourseDomain(domain2, course5);

        session.save(courseDomain3);
        session.save(courseDomain4);
        session.save(courseDomain5);

        Grades grade1 = new Grades('A', 85);
        Grades grade2 = new Grades('B', 75);
        Grades grade3 = new Grades('C', 60);
        Grades grade4 = new Grades('D', 50);
        Grades grade5 = new Grades('F', 40);

        session.save(grade1);
        session.save(grade2);
        session.save(grade3);
        session.save(grade4);
        session.save(grade5);

        List<Students> students = new ArrayList<Students>();

        for(int i=1; i<=20; i++) {
            String roll_number = "roll" + i;
            String first_name = "student" + i;
            String mail = "student" + i + "@mail.com";

            students.add(new Students(roll_number, first_name, mail, (float)0.0, 2));
            session.save(students.get(i-1));
        }

        for(int i=1; i<=20; i++) {
            if(i % 5 == 0)
                session.save(new StudentCourses(students.get(i-1), course1, grade1));
            else if(i % 5 == 1)
                session.save(new StudentCourses(students.get(i-1), course2, grade2));
            else if(i % 5 == 2)
                session.save(new StudentCourses(students.get(i-1), course3, grade3));
            else if(i % 5 == 3)
                session.save(new StudentCourses(students.get(i-1), course4, grade4));
            else
                session.save(new StudentCourses(students.get(i-1), course5, grade5));
        }

        session.getTransaction().commit();
        session.close();
    }
}
