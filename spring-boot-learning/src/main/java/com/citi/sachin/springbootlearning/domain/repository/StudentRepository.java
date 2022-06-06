package com.citi.sachin.springbootlearning.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citi.sachin.springbootlearning.domain.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public Student findByName(String name);

	@Query("FROM Student s WHERE s.name=:name")
	Optional<Student> filterByName(@Param("name") String name);

	@Query("FROM Student s JOIN s.passport")
	List<Student> getAllStudentWithPassport();

	@Query(nativeQuery = true, value = "select s.name,c.name from student s, course c ,student_course sc where s.id = sc.student_id and c.id = sc.course_id")
	List<Student> getStudentAndCourses();

}
