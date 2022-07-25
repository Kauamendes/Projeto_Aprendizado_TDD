package com.example.tdd.estudo.demo.modules.courses.repositories;

import com.example.tdd.estudo.demo.modules.courses.entities.Course;

public interface ICourseRepository {

	public Course findByName(String name);
	
	public Course save(Course course);
	
}
