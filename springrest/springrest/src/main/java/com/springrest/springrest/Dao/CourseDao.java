package com.springrest.springrest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entity.Course;

public interface CourseDao extends JpaRepository<Course , Long>{
    
}
