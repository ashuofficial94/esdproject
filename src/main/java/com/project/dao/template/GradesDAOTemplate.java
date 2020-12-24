package com.project.dao.template;

import com.project.bean.Courses;
import com.project.bean.Grades;
import com.project.bean.Students;

import java.util.List;

public interface GradesDAOTemplate {

    public Grades getStudentGrade(Students student, Courses course);
    public List<Grades> getGrades();
}
