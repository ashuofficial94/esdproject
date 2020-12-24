package com.project.dao;

import com.project.bean.Courses;
import com.project.bean.Grades;
import com.project.bean.StudentCourses;
import com.project.bean.Students;
import com.project.dao.template.GradesDAOTemplate;
import com.project.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class GradesDAO implements GradesDAOTemplate {
    @Override
    public Grades getStudentGrade(Students student, Courses course) {

        try(Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from StudentCourses where student_id =: student_id and course_id =: course_id");
            query.setParameter("student_id", student.getStudent_id());
            query.setParameter("course_id", course.getCourse_id());

            for(final Object fetch: query.list()) {
                StudentCourses studentCourses = (StudentCourses) fetch;
                return studentCourses.getGrade_id();
            }

        }

        catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }

        return null;
    }

    @Override
    public List<Grades> getGrades() {

        try(Session session = SessionUtil.getSession()) {

            List<Grades> grades = new ArrayList<Grades>();

            Query query = session.createQuery("from Grades");

            for(final Object fetch: query.list()) {
                grades.add((Grades) fetch);
            }

            return grades;
        }

        catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }
}
