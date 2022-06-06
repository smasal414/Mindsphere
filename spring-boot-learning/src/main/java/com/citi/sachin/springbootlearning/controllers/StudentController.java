package com.citi.sachin.springbootlearning.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.citi.sachin.springbootlearning.domain.entity.Student;
import com.citi.sachin.springbootlearning.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	StudentService studentService;
private static Logger logger = LoggerFactory.getLogger(StudentController.class);
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	CourseController courseController;

	@GetMapping
	public List<Student> getStudent() {
		System.out.println(System.out);
		return this.studentService.studentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable() Long id) {
		Optional<Student> optional = this.studentService.studentRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@GetMapping("/getstudentswithpassport")
	public List<Student> getStudentsWithPassport() {
		return this.studentService.studentRepository.getAllStudentWithPassport();
	}

	@GetMapping("/manyToManyQuery")
	public List<Student> getStudentsWithCourses() {
		return this.studentService.studentRepository.getStudentAndCourses();
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/weather")
	public ResponseEntity<List<Object>> getWeather() {
		@SuppressWarnings("rawtypes")
		ArrayList forObject = this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos",
				new ArrayList().getClass());
		return new ResponseEntity<List<Object>>(forObject, HttpStatus.ACCEPTED);
	}

	@PostMapping("/save-students")
	public List<Student> SaveStudents(@RequestBody() List<Student> students) {
		List<Student> students2 = this.studentService.studentRepository.saveAll(students);
		return students2;
	}

	@GetMapping("searchbar/{name}")
	public Optional<Student> findByName(@PathVariable() String name) {
		return this.studentService.studentRepository.filterByName(name);
	}

	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody() Student student) {
		Student savedStudent = this.studentService.studentRepository.save(student);
		return ResponseEntity<Student>
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable() Long id) {
		this.studentService.studentRepository.deleteById(id);
	}

	@PostMapping("/updatestandrdmultiple")
	public List<Student> updateStandards(@RequestBody List<Student> Standards) {
		{

			List<Student> standard = new ArrayList<Student>(); // empty array list

			for (Student eachStudentStd : Standards) {
				Optional<Student> optinal = this.studentService.studentRepository.findById(eachStudentStd.getId());
				if (optinal.isPresent()) {
					Student bd = optinal.get();
					bd.setStd(eachStudentStd.getStd());
					this.studentService.studentRepository.save(bd);
				}
			}
			return standard;

		}

	}
@PostMapping("/upadtestudentname")

	public List <Student> upadteNmaes(@RequestBody List<Student> name )
	{
		List<Student> names = new ArrayList<Student>();
	if (names != null) {
		for (Student eachStudentName : names) {
			Optional<Student> ham = this.studentService.studentRepository.findById(eachStudentName.getId());
			if (ham.isPresent()) {
				Student dbd = ham.get();
				dbd.setName(eachStudentName.getName());
				this.studentService.studentRepository.save(dbd);
			}
		}
		logger.info("data saved successfully");
	}
		return names;
	}
	}
