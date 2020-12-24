package com.project.controller;

import com.project.bean.Employees;
import com.project.service.EmployeesService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("employees")
public class EmployeesController {

    EmployeesService employeesService = new EmployeesService();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response loginEmployee(Employees employee) throws URISyntaxException {
        Employees result = employeesService.emailVerify(employee);

        if(result == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }
}
