package com.citi.sachin.springbootlearning.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql = "update student set is_deleted=true where id=?")
@Where(clause = "is_deleted = false")
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String std;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Passport passport;

	@ManyToMany
	@JoinTable(name = "Student_Course", joinColumns = @JoinColumn(name = "Student_Id"), inverseJoinColumns = @JoinColumn(name = "Course_Id"))
	private List<Course> courses = new ArrayList<>();

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	private Boolean isDeleted = false;

	public Student() {
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
