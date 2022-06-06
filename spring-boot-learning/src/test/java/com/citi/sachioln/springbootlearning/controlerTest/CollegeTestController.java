package com.citi.sachioln.springbootlearning.controlerTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.citi.sachin.springbootlearning.controllers.CollegeController;
import com.citi.sachin.springbootlearning.domain.entity.College;
import com.citi.sachin.springbootlearning.domain.repository.CollegeRepository;
import com.citi.sachin.springbootlearning.service.CollegeService;

@ExtendWith(MockitoExtension.class)
public class CollegeTestController {

	@InjectMocks
	CollegeController collegeController;

	@Mock
	CollegeService collegeService;

	@Mock
	CollegeRepository collegeRepository;

	private College college;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void check() {
		MockitoAnnotations.initMocks(this);
		this.collegeService.collegeRepository = this.collegeRepository;
		college = new College();
		college.setCollegeName("SINHGAD");
	}

//	@Test
//	void saveCollegeTest() {
//		college.setCollegeName("sinhgad");
//		when(this.collegeService.collegeRepository.save(college)).thenReturn(college);
//		College saveCollege = this.collegeController.saveCollege(college);
//		assertEquals(college.getCollegeName(), saveCollege.getCollegeName());
//	}

	@Test
	public void updateAddresessTest() throws Exception {
		college.setCollegeAdress("Solapur");
		List<College> list = new ArrayList<College>();
		list.add(college);
		when(this.collegeService.collegeRepository.findById(college.getCollegeId())).thenReturn(Optional.of(college));
		List<College> updateAddresess = this.collegeController.updateAddresess(list);
		assertEquals(college.getCollegeAdress(), updateAddresess.get(0).getCollegeAdress());
		
		when(this.collegeService.collegeRepository.findById(null))
				.thenThrow(new NullPointerException("Invalid college address"));
		try {
			College college2 = new College();
			college2.setCollegeId(null);
			this.collegeController.updateAddresess(List.of());
		}catch(Exception exception) {
			assertEquals("Invalid college address", exception.getMessage());
		}
		
//		try {
//			this.collegeService.collegeRepository = null;
//			this.collegeController.updateAddresess(null);
//		} catch (Exception e) {
//			assertEquals("Invalid addresses", e.getMessage());
//		}
	}

}
