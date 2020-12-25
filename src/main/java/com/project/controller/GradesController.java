package com.project.controller;

import com.project.bean.Grades;
import com.project.bean.StudentCourses;

import com.project.service.GradesService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("grades")
public class GradesController {

    GradesService gradesService = new GradesService();

    @POST
    @Path("/change")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)

    public Response changeGrades(@FormDataParam("student_id") Integer student_id,
                                 @FormDataParam("course_id") Integer course_id,
                                 @FormDataParam("grade_id") Integer grade_id) throws URISyntaxException {

        Grades grade = new Grades();

//        int student_id = studentCourses.getStudent_id().getStudent_id();
//        int course_id = studentCourses.getCourse_id().getCourse_id();
//        int grade_id = studentCourses.getGrade_id().getGrade_id();

        System.out.println(student_id);
        System.out.println(course_id);
        System.out.println(grade_id);

        if(grade_id == 100)
            grade.setLetter_grade(' ');

        else
            grade = gradesService.changeStudentGrade(student_id, course_id, grade_id);

        return Response.ok().entity(grade).build();
    }

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

}
