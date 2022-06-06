package com.citi.sachin.springbootlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.sachin.springbootlearning.domain.repository.PassportRepository;

@Service
public class PassportService {

	@Autowired
	public PassportRepository passportRepository;
}
