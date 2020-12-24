import com.project.bean.Courses;
import com.project.bean.StudentCourses;
import com.project.bean.Students;
import com.project.service.CourseService;
import com.project.utils.SessionUtil;
import org.hibernate.Session;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();

        CourseService courseService = new CourseService();

        Courses course = new Courses();
        course.setCourse_id(1);
        List<Students> students = courseService.getStudents(course);

        for(Students student: students) {
            System.out.println(student.getEmail());
        }

        session.getTransaction().commit();
        session.close();
    }
}
