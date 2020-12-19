package com.example.erp.controller;

import com.example.erp.bean.Courses;
import com.example.erp.service.CoursesService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("courses")
public class CoursesController {

    CoursesService courseService = new CoursesService();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourses() {
        List<Courses> courses = courseService.getCourses();
        return Response.ok().entity(courses).build();
    }

}
