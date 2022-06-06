package com.citi.sachin.springbootlearning.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.citi.sachin.springbootlearning.domain.entity.Course;

@Transactional
public interface CourseRepository extends JpaRepository<Course, Long> {

}
