package com.project.controller;

import com.project.bean.CourseDomain;
import com.project.bean.Courses;
import com.project.bean.Domains;
import com.project.service.DomainsService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("domains")
public class DomainsController {

    DomainsService domainsService = new DomainsService();

    @POST
    @Path("/get-domains")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getDomains() throws URISyntaxException {
        List<Domains> domains = domainsService.getDomains();
        if(domains == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(domains).build();
    }

    @POST
    @Path("/add-domain")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)

    public Response addDomain(@FormDataParam("batch") Integer batch,
                              @FormDataParam("capacity") Integer capacity,
                              @FormDataParam("program") String program,
                              @FormDataParam("qualification") String qualification) throws URISyntaxException {

        Domains domain = new Domains(program, batch, capacity, qualification);
        if(domainsService.addDomain(domain)) {
            return Response.ok().build();
        }

        return Response.status(203).build();
    }

    @POST
    @Path("/get-courses")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response getCourses(Domains domain) throws URISyntaxException {

        List<CourseDomain> courseDomains = domainsService.getCourses(domain);

        List<Courses> courses = new ArrayList<Courses>();
        for(CourseDomain courseDomain: courseDomains) {
            courses.add(courseDomain.getCourse_id());
        }

        if(courseDomains == null) {
            return Response.noContent().build();
        }

        return Response.ok().entity(courses).build();
    }
}
