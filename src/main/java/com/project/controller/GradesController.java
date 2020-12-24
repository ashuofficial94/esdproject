package com.project.controller;

import com.project.bean.Grades;
import com.project.bean.StudentCourses;

import com.project.service.GradesService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("grades")
public class GradesController {

    GradesService gradesService = new GradesService();

    @POST
    @Path("/student-grade")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response getStudentGrade(StudentCourses studentCourses) {

        int student_id = studentCourses.getStudent_id().getStudent_id();
        int course_id = studentCourses.getCourse_id().getCourse_id();

        Grades grade = gradesService.getStudentGrade(student_id, course_id);

        return Response.ok().entity(grade).build();
    }

    @POST
    @Path("/get-grades")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getGrades() {

        List<Grades> grades = gradesService.getGrades();

        if(grades == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(grades).build();
    }

    @POST
    @Path("/change-grade")
    @Consumes(MediaType.APPLICATION_JSON)

    public Response changeGrades(StudentCourses studentCourses) {
        boolean result = gradesService.changeStudentGrade(studentCourses.getStudent_id().getStudent_id(),
                studentCourses.getCourse_id().getCourse_id(),
                studentCourses.getGrade_id().getGrade_id());

        if(result) {
            return Response.ok().build();
        }

        return Response.noContent().build();
    }
}
