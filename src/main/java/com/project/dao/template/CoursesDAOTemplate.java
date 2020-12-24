package com.project.dao.template;

import com.project.bean.Courses;
import com.project.bean.Students;

import java.util.List;

public interface CoursesDAOTemplate {
    public List<Students> getStudents(Courses course);
}
