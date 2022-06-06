package com.citi.sachin.springbootlearning.controlerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citi.sachin.springbootlearning.controllers.CourseController;
import com.citi.sachin.springbootlearning.domain.entity.Course;
import com.citi.sachin.springbootlearning.domain.repository.CourseRepository;
import com.citi.sachin.springbootlearning.service.CourseService;

@ExtendWith(MockitoExtension.class)
public class CourseControllerTest {
	@InjectMocks
	CourseController courseController;
	
	@Mock
	CourseService courseService;
	@Mock
	CourseRepository courseRepository;
	
	private Course course;
	@BeforeEach
	void check() {
		course= new  Course();
		this.courseService.courseRepository=this.courseRepository;
		
	}
	
@Test
void CourseControllerTest() {
	course.setId(123L);
	this.courseService.courseRepository=this.courseRepository;
	when(this.courseService.courseRepository.save(course)).thenReturn(course);
	Course saveCourse = this.courseController.saveCourse(course);
	assertEquals(course.getId(), saveCourse.getId());
	
}

@Test
void saveCoursesTest()
{
	course.setName("java");
	List<Course> list = new ArrayList<>();
	list.add(course);
	when(this.courseService.courseRepository.save(course)).thenReturn(course);
	Course saveCourse = this.courseController.saveCourse(course);
	assertEquals(saveCourse.getName(), "java");
	
}



}
