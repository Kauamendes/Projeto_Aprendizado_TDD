package com.example.tdd.estudo.demo.modules.courses.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdd.estudo.demo.modules.courses.entities.Course;

@Service
public class CourseRepository implements ICourseRepository{

	@Autowired
	CourseJPARepository courseJPARepository;
	
	@Override
	public Course findByName(String name) {
		return this.courseJPARepository.findByName(name);
	}

	@Override
	public Course save(Course course) {
		return this.courseJPARepository.save(course);
	}

}
