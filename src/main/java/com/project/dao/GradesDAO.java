package com.project.dao;

import com.project.bean.Courses;
import com.project.bean.Grades;
import com.project.bean.StudentCourses;
import com.project.bean.Students;
import com.project.dao.template.GradesDAOTemplate;
import com.project.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class GradesDAO implements GradesDAOTemplate {
    @Override
    public Grades changeStudentGrade(int student_id, int course_id, int grade_id) {
        try(Session session = SessionUtil.getSession()) {

            session.beginTransaction();
            String sql = String.format("update Student_Courses set grade_id = %d where student_id = %d and course_id = %d",
                        grade_id, student_id, course_id);

            NativeQuery query = session.createSQLQuery(sql);
            int rows = query.executeUpdate();

            Query get_grade_query = session.createQuery("from Grades where grade_id =: grade_id");
            get_grade_query.setParameter("grade_id", grade_id);

            for(final Object fetch: get_grade_query.list()) {
                return (Grades) fetch;
            }

            return null;
        }

        catch(HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Grades getStudentGrade(int student_id, int course_id) {

        try(Session session = SessionUtil.getSession()) {

            String sql = String.format("SELECT * FROM Student_Courses where student_id = %d and course_id = %d;",
            student_id, course_id);

            NativeQuery query = session.createSQLQuery(sql);
            query.addEntity(StudentCourses.class);


//            Query query = session.createQuery("from StudentCourses where student_id =: student_id and course_id =: course_id");
//            query.setParameter("student_id", student_id);
//            query.setParameter("course_id", course_id);

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
