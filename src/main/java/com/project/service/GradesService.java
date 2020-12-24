package com.project.service;

import com.project.bean.Courses;
import com.project.bean.Grades;
import com.project.bean.Students;
import com.project.dao.GradesDAO;

import java.util.List;

public class GradesService {

    GradesDAO gradesDAO = new GradesDAO();
    public Grades getStudentGrade(Students student, Courses course) { return gradesDAO.getStudentGrade(student, course); }
    public List<Grades> getGrades() { return gradesDAO.getGrades(); }
}
