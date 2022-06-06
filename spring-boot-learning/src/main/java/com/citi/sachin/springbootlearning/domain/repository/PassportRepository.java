package com.citi.sachin.springbootlearning.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.sachin.springbootlearning.domain.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
