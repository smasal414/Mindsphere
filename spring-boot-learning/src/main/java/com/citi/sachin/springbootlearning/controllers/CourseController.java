package com.citi.sachin.springbootlearning.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.sachin.springbootlearning.domain.entity.Course;
import com.citi.sachin.springbootlearning.service.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping
	public List<Course> getCourse() {
		return this.courseService.courseRepository.findAll();
	}

	@GetMapping("/{id}")
	public Course getCourse(@PathVariable("id") Long id) {
		Optional<Course> courseOptional = this.courseService.courseRepository.findById(id);
		if (courseOptional.isPresent()) {
			return courseOptional.get();
		} else {
			return null;
		}
	}

	@PostMapping("/save")
	public Course saveCourse(@RequestBody() Course course) {
		Course savedCourse = this.courseService.courseRepository.save(course);
		return savedCourse;
	}

	@PostMapping("/saveCourses")
	public List<Course> saveCourses(@RequestBody List<Course> courses) {
		List<Course> saveCourses = this.courseService.courseRepository.saveAll(courses);
		if (saveCourses.size() == courses.size()) {
			return saveCourses;
		}
		return Arrays.asList();
	}

	@PostMapping("updatename/{id}")
	public Course updateCourseName(@RequestBody String name, @PathVariable() Long id) {
		Optional<Course> optional = this.courseService.courseRepository.findById(id);
		if (optional.isPresent()) {
			Course course = optional.get();
			course.setName(name);
			return this.updateCourse(course);
		}
		return null;
	}

	@PostMapping("update")
	public Course updateCourse(@RequestBody Course course) {
		Course savedCourse = this.courseService.courseRepository.save(course);
		if (savedCourse != null) {
			return savedCourse;
		}

		return null;

	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable() Long id) {
		this.courseService.courseRepository.deleteById(id);
	}

	@PostMapping("/updatemultiplefee")
	public List<Course> updateCourseFees(@RequestBody List<Course> fees) {
		for (Course eachCourseFees : fees) {

			Optional<Course> college = this.courseService.courseRepository.findById(eachCourseFees.getId());

			if (college.isPresent()) {
				Course scCourse = college.get();
				scCourse.setFee(eachCourseFees.getFee());
				this.courseService.courseRepository.save(scCourse);
			}
		}
		return null;

	}
	
	@PostMapping("/updatemultiplecoarses")
	public List<Course> updateCoaurseNmae(@RequestBody() List<Course> names)
	{
		for (Course eachCourseName : names)
		{
			Optional<Course> course = this.courseService.courseRepository.findById(eachCourseName.getId());
			if (course.isPresent())
			{
				Course course2 = course.get();
				course2.setName(eachCourseName.getName());
				this.courseService.courseRepository.save(course2);
			}
			
	}
	
	return names;
}
}