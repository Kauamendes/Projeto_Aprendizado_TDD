package com.example.tdd.estudo.demo.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tdd.estudo.demo.modules.courses.entities.Course;
import com.example.tdd.estudo.demo.modules.courses.repositories.CourseRepository;
import com.example.tdd.estudo.demo.modules.courses.services.CreateCourseService;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository repository;

	@PostMapping(value = "/")
	public Course createCourse(@RequestBody Course course) {
		CreateCourseService createCourseService = new CreateCourseService(repository);
		return createCourseService.execute(course);
		
	}
	
}
