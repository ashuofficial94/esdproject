package com.project.controller;

import com.project.bean.Courses;
import com.project.bean.Students;
import com.project.service.CourseService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("courses")
public class CoursesController {

    CourseService courseService = new CourseService();

    @POST
    @Path("/get-students")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response getStudents(Courses course) throws URISyntaxException {

        List<Students> studentsList = courseService.getStudents(course);

        if(studentsList == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(studentsList).build();
    }

}
