package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;  
import com.springrest.springrest.services.CourseService;

@RestController

public class Mycontroller {

    @Autowired

    public CourseService courseService ;

    @GetMapping("/home")
    public String home(){
        return "this is home" ;
    }

    //get the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){

        return this.courseService.getCourses() ;


    }

    @Getmapping("/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return this.courseService.getCourse(Long.parseLong(id)) ;

    }

    @PostMapping("/addcourse")
    public Course addCourse(@RequestBody Course course){

        return this.courseService.addCourse(course) ;
    }

    
}
