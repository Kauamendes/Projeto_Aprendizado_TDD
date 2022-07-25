package com.example.tdd.estudo.demo.modules.courses.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdd.estudo.demo.modules.courses.entities.Course;
import com.example.tdd.estudo.demo.modules.courses.repositories.CourseJPARepository;
import com.example.tdd.estudo.demo.modules.courses.repositories.ICourseRepository;

@Service
public class CreateCourseService {
	
	private ICourseRepository repository;
	
	public CreateCourseService(ICourseRepository repository) {
		this.repository = repository;
	}

	public Course execute(Course course) {
		
		Course existedCourse = repository.findByName(course.getName());
		
		if(existedCourse != null) {
			throw new Error("Curso já existe");
		}
		
		return repository.save(course);
	}
	
}
