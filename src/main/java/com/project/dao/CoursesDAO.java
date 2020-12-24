package com.project.dao;

import com.project.bean.Courses;
import com.project.bean.StudentCourses;
import com.project.bean.Students;
import com.project.dao.template.CoursesDAOTemplate;
import com.project.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CoursesDAO implements CoursesDAOTemplate {

    @Override
    public List<Students> getStudents(Courses course) {

        List<Students> students = new ArrayList<Students>();

        try (Session session = SessionUtil.getSession()){

            Query query = session.createQuery("from Courses where course_id =: course_id");
            query.setParameter("course_id", course.getCourse_id());

            for (final Object fetch: query.list()) {

                course = (Courses) fetch;
                List<StudentCourses> studentCoursesList = course.getStudentCoursesList();
                for(StudentCourses studentCourses: studentCoursesList) {
                    students.add(studentCourses.getStudent_id());
                }
            }
            return students;
        }

        catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }
}
