package com.example.erp.dao.impl;

import com.example.erp.bean.Courses;
import com.example.erp.dao.CoursesDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CoursesDaoImpl implements CoursesDao {


    @Override
    public List<Courses> getCourses() {
        Session session = SessionUtil.getSession();
        List<Courses> courses = new ArrayList<>();
        try {
            for (final Object course : session.createQuery("from Courses ").list()) {
                courses.add((Courses) course);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return courses;
    }
}
