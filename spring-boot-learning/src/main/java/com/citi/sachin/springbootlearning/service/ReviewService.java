package com.citi.sachin.springbootlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.sachin.springbootlearning.domain.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	public ReviewRepository reviewRepository;
}
