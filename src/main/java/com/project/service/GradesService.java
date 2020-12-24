package com.project.service;

import com.project.bean.Courses;
import com.project.bean.Grades;
import com.project.bean.Students;
import com.project.dao.GradesDAO;

import java.util.List;

public class GradesService {

    GradesDAO gradesDAO = new GradesDAO();
    public Grades getStudentGrade(int student_id, int course_id) { return gradesDAO.getStudentGrade(student_id, course_id); }
    public List<Grades> getGrades() { return gradesDAO.getGrades(); }
    public boolean changeStudentGrade(int student_id, int course_id, int grade_id) { return gradesDAO.changeStudentGrade(student_id, course_id, grade_id); }
}
