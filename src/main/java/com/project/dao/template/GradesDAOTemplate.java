package com.project.dao.template;

import com.project.bean.Courses;
import com.project.bean.Grades;
import com.project.bean.Students;

import java.util.List;

public interface GradesDAOTemplate {

    public Grades getStudentGrade(int student_id, int course_id);
    public List<Grades> getGrades();
    public boolean changeStudentGrade(int student_id, int course_id, int grade_id);
}
