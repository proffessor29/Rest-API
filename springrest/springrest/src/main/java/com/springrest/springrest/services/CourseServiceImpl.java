package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao ;

   // List<Course> list;

    public CourseServiceImpl(){
      //  list = new ArrayList<>() ;
       // list.add(new Course(145, "java Core Course", "this course contains basics of java")) ;
        //list.add(new Course(157 , "spring boot" ,  "VALUE")) ;
    }



    @Override
    public List<Course> getCourses(){
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long id){
        
     //   Course c = null ;
     //   for(Course course:list){
     //       if(course.getID()== id){
     //           c = course ;
     //           break ;
     //       }
     //   }
        
        return courseDao.getReferenceById(id);
    }
    
    @Override
    public Course addCourse(Course course) {
     //   list.add(course) ;
        courseDao.save(course) ;
        return course;
    }
}
