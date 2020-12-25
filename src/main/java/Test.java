import com.project.bean.Courses;
import com.project.bean.Grades;
import com.project.bean.StudentCourses;
import com.project.bean.Students;
import com.project.dao.GradesDAO;
import com.project.service.CourseService;
import com.project.service.DomainsService;
import com.project.service.GradesService;
import com.project.utils.SessionUtil;
import org.hibernate.Session;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();

        GradesDAO gradesDAO = new GradesDAO();
        List<Grades> grades = gradesDAO.getGrades();

        System.out.println(gradesDAO.getStudentGrade(4, 5).getLetter_grade());
        Grades grade = gradesDAO.changeStudentGrade(4, 5, 1);

        System.out.println(gradesDAO.getStudentGrade(4, 5).getLetter_grade());
        System.out.println(grade.getLetter_grade());

        session.getTransaction().commit();
        session.close();
    }
}
