package com.citi.sachin.springbootlearning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLearningApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLearningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("My first spring boot applciation..");
	}

}
