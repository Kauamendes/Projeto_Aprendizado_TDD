package com.example.tdd.estudo.demo.modules.courses.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.tdd.estudo.demo.modules.courses.entities.Course;

public class CourseImMemoryRepository implements ICourseRepository {

	List<Course> courses;
	
	public CourseImMemoryRepository() {
		this.courses = new ArrayList<Course>();
	}
	
	@Override
	public Course findByName(String name) {
		Optional<Course> optionalCourse = this.courses.stream().filter(course -> course.getName().equals(name)).findFirst();
		return optionalCourse.orElse(null);
		
	}

	@Override
	public Course save(Course course) {
		this.courses.add(course);
		course.setId(UUID.randomUUID());
		return course;
	}

}
