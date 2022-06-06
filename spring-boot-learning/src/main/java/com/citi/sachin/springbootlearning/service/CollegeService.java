package com.citi.sachin.springbootlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.sachin.springbootlearning.domain.entity.College;
import com.citi.sachin.springbootlearning.domain.repository.CollegeRepository;

@Service
public class CollegeService {

	@Autowired
	public CollegeRepository collegeRepository;

}
