package com.project.service;

import com.project.bean.Courses;
import com.project.bean.Students;
import com.project.dao.CoursesDAO;

import java.util.List;

public class CourseService {

    CoursesDAO coursesDAO = new CoursesDAO();
    public List<Students> getStudents(Courses course) { return coursesDAO.getStudents(course); }
}
