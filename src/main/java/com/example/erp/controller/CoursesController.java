package com.example.erp.controller;

import com.example.erp.bean.Courses;
import com.example.erp.service.CoursesService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("courses")
public class CoursesController {

    CoursesService courseService = new CoursesService();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourses() {
        List<Courses> courses = courseService.getCourses();
        System.out.println("Controller Working");

        List<JSONObject> resultobject = new ArrayList<>();
        try {
            resultobject = getCourseJsonArray(courses);
        }
    catch (org.json.JSONException exception)
        {
            exception.printStackTrace();
        }
        if (courses == null) {
            return Response.noContent().build();
        }
//    System.out.println("size of list"+courses.get(0).getStudents().size());
//    System.out.println("size of list"+courses.get(1).getStudents().size());
        return Response.ok(resultobject.toString()).build();
    }



            //        System.out.println("student list size is"+courses.get(0).getStudents().size());
//        System.out.println("student name"+courses.get(0).getStudents().get(0).getFirst_name());
//
//        List<Data> data=new ArrayList<Data>();
//
//
//        for(int i=0;i<courses.size();i++)
//        {
//            Data d=new Data();
//           d.setCourse_id(courses.get(i).getCourse_id());
//           d.setCourse_code(courses.get(i).getCourse_code());
//           d.setName(courses.get(i).getName());
//           d.setDescription(courses.get(i).getDescription());
//           d.setYear(courses.get(i).getYear());
//           d.setTerm(courses.get(i).getTerm());
//           d.setCredits(courses.get(i).getCredits());
//           d.setCapacity(courses.get(i).getCapacity());
//           d.setFaculty(courses.get(i).getFaculty());
//           d.setCount(courses.get(i).getStudents().size());
//           data.add(i,d);
//        }
        //return Response.ok().entity(data).build();

        //System.out.println(courses.size());


    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourses(Courses courses)
    {
        System.out.println("in course controller"+courses.getCourse_id());
        boolean status=courseService.deleteCourses(courses);
        System.out.println(status);
        return (Response.ok().build());
        //return Response.status(203).build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCourses(Courses courses)
    {
        System.out.println("in course controller"+courses.getCourse_id());
        boolean status=courseService.updateCourses(courses);
        System.out.println(status);
        return (Response.ok().build());
    }


    @POST
    @Path("/course_data")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_course_data(Courses courses)
    {
        //System.out.println("get_course_controller");
      Courses course_data= courseService.getCourse_data(courses);
     System.out.println(course_data.getCourse_code());
//      List<Courses> courses1=new ArrayList<>();
//      courses1.add(course_data);
//
//        List<JSONObject> resultobject = new ArrayList<>();
//        try {
//            resultobject = getCourseJsonArray(courses1);
//        }
//        catch (org.json.JSONException exception)
//        {
//            exception.printStackTrace();
//        }
//        if (courses == null) {
//            return Response.noContent().build();
//        }
//        System.out.println("size of list"+courses.get(0).getStudents().size());
//        System.out.println("size of list"+courses.get(1).getStudents().size());
//        return Response.ok(resultobject.toString()).build();
return Response.ok().entity(course_data).build();
    }


    JSONArray jsonArray=new JSONArray();
    public List<JSONObject> getCourseJsonArray(List<Courses> courses) throws JSONException {
        List<JSONObject> jsonObjectList =new ArrayList<>();
        //List<JSONObject> jsonObjectList1=new ArrayList<>();
        try{
            for(Courses each_course:courses)
            {
                JSONObject jsonobject=new JSONObject();
                //  JSONArray jsonArray = ;
                jsonobject.put("course_id",each_course.getCourse_id());
                jsonobject.put("course_code",each_course.getCourse_code());
                jsonobject.put("name",each_course.getName());
                jsonobject.put("description",each_course.getDescription());
                jsonobject.put("year",each_course.getYear());
                jsonobject.put("term",each_course.getTerm());
                jsonobject.put("credits",each_course.getCredits());
                jsonobject.put("capacity",each_course.getCapacity());
                jsonobject.put("faculty",each_course.getFaculty());
                jsonobject.put("count",each_course.getStudents().size());

/*
                for(Students each_student:each_course.getStudents())
                {
                    jsonArray.put(each_student.getStudent_id());
                    jsonArray.put(each_student.getFirst_name());
                    jsonArray.put(each_student.getLast_name());
                    jsonArray.put(each_student.getEmail());
                }
                jsonobject.put("students",jsonArray);*/
                jsonObjectList.add(jsonobject);
            }

        }
        catch (org.json.JSONException exception)
        {
            exception.printStackTrace();
        }
        return jsonObjectList;
    }



    }

