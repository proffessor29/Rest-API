package com.springrest.springrest.services;
import java.util.List ;

import com.springrest.springrest.entity.Course;

public interface CourseService {

    public List<Course> getCourses() ;
    
    public Course getCourse(long id) ;

    public Course addCourse(Course course) ;

}

