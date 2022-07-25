package com.example.tdd.estudo.demo.services;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;


public class CreateCourseServiceTest {
	
	@Test			//deveCriarUmNovoCursoSeNaoExistirNoBanco
	public void should_be_able_to_create_a_new_course() {
		//criar um novo curso
		
		//criar table(entidade)
		Course course = new Course();
		course.setDescription("curso descripion teste");
		course.setName("nome teste");
		course.setWorkload(100);
		
		//criar um novo service
		CreateCourseService createCourseService = new CreateCourseService();
		Course createdCourse = createCourseService.execute(course);
		
		//criar um repository de curso
		
		assertNotNull(createdCourse.getId());
		
	}

}
