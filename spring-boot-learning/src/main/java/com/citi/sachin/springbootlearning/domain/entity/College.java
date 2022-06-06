package com.citi.sachin.springbootlearning.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class College {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long collegeId;

	@Column(name = "college_name")
	private String collegeName;

	@Column(name = "college_adress")
	private String collegeAdress;

	@Column(name = "college_Rank")
	private Long collegeRank;

	public College(Long collegeId, String collegeName, String collegeAdress, Long collegeRank) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeAdress = collegeAdress;
		this.collegeRank = collegeRank;
	}

	public College() {
		super();
	}

	public Long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeAdress() {
		return collegeAdress;
	}

	public void setCollegeAdress(String collegeAdress) {
		this.collegeAdress = collegeAdress;
	}

	public Long getCollegeRank() {
		return collegeRank;
	}

	public void setCollegeRank(Long collegeRank) {
		this.collegeRank = collegeRank;
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeAdress=" + collegeAdress
				+ ", collegeRank=" + collegeRank + "]";
	}

	
}
