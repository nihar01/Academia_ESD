package com.example.erp.service;

import com.example.erp.bean.Courses;
import com.example.erp.dao.CoursesDao;
import com.example.erp.dao.impl.CoursesDaoImpl;

import java.util.List;

public class CoursesService {

    CoursesDao coursesDao=new CoursesDaoImpl();

    public List<Courses> getCourses (){
        return coursesDao.getCourses();
    }
}
