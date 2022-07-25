package com.example.tdd.estudo.demo.services;

import static org.junit.Assert.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.tdd.estudo.demo.modules.courses.entities.Course;
import com.example.tdd.estudo.demo.modules.courses.repositories.CourseImMemoryRepository;
import com.example.tdd.estudo.demo.modules.courses.services.CreateCourseService;


public class CreateCourseServiceTest {
	
	@Test			//deveCriarUmNovoCursoSeNaoExistirNoBanco
	public void should_be_able_to_create_a_new_course() {
		//criar um novo curso
		
		//criar table(entidade)
		Course course = new Course();
		course.setDescription("curso descripion teste");
		course.setName("nome teste");
		course.setWorkload(100);
		
		//criar um repository de curso
		CourseImMemoryRepository repository = new CourseImMemoryRepository();
		
		//criar um novo service
		CreateCourseService createCourseService = new CreateCourseService(repository);
		Course createdCourse = createCourseService.execute(course);
		
		
		
		assertNotNull(createdCourse.getId());
		
	}
	
	@Test			//naoDeveCriarUmNovoCursoSeJaExistir
	public void should_not_be_able_to_create_a_new_course_if_exists() {
		//criar um novo curso
		
				//criar table(entidade)
				Course course = new Course();
				course.setDescription("curso descripion teste");
				course.setName("nome teste");
				course.setWorkload(100);
				
				CourseImMemoryRepository repository = new CourseImMemoryRepository();
				
				//criar um novo service
				CreateCourseService createCourseService = new CreateCourseService(repository);
				createCourseService.execute(course);
				
				
				Throwable exception = Assertions.catchThrowable( () -> createCourseService.execute(course));

				
				Assertions.assertThat(exception).isInstanceOf(Error.class);
				
	}

}
