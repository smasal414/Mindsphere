package com.citi.sachin.springbootlearning.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.sachin.springbootlearning.domain.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
