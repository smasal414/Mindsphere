package com.citi.sachin.springbootlearning.domain.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.citi.sachin.springbootlearning.domain.constants.ReviewRating;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(value = EnumType.STRING)
	private ReviewRating rating;

	@ManyToOne
	private Course course;

	public Review() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
