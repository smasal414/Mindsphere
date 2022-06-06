package com.citi.sachin.springbootlearning.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citi.sachin.springbootlearning.domain.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {


   public  College findByCollegeName(String collegeName);
}
