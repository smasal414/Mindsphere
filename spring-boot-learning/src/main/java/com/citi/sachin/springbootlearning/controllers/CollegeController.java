package com.citi.sachin.springbootlearning.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.sachin.springbootlearning.domain.entity.College;
import com.citi.sachin.springbootlearning.exceptions.ElementNoFoundException;
import com.citi.sachin.springbootlearning.exceptions.NoSuchElementFoundException;
import com.citi.sachin.springbootlearning.service.CollegeService;

@RestController
@RequestMapping("/apisearch")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	private static Logger logger = LoggerFactory.getLogger(CollegeController.class);

	@PostMapping("/savecollege")
	public College saveCollege(@RequestBody() College college) throws Exception {

//		if (college == null)
//		{
//			throw new Exception();
//		}
		return this.collegeService.collegeRepository.save(college);


	}

	@PostMapping("/savecolleges")
	public List<College> saveCollege(@RequestBody() List<College> colleges) {
		List<College> saveRecords = this.collegeService.collegeRepository.saveAll(colleges);
		return saveRecords;
	}

	@PostMapping("/saveAdress")
	public College saveCollegeAdress(@RequestBody() College adress) {
		College save2 = this.collegeService.collegeRepository.save(adress);
		return save2;

	}

	@SuppressWarnings("unused")
	@PostMapping("/updateallcollege")
	public ResponseEntity< List<College> > updateAllCollege(@RequestBody() List<College> college)
	{
		if (college.isEmpty())
		{
			throw new ElementNoFoundException();
		}
		ResponseEntity<College> responseEntity = null;
		List<College> saveAll2 = this.collegeService.collegeRepository.saveAll(college);
		logger.info("given record is updated");
		return new ResponseEntity<List<College>>(saveAll2, HttpStatus.CREATED);

	}
	
		
	
	public ResponseEntity<College> findCollegeById(@PathVariable Long id) throws NoSuchElementFoundException
	{
	Optional<College> opCollege = this.collegeService.collegeRepository.findById(id);
		if (opCollege.isEmpty())
		{
			throw new NoSuchElementFoundException();
		}	
	
	return new ResponseEntity<College>(HttpStatus.FOUND);
	}

	@GetMapping("/fetchbyid/{id}")
	public College findCollegebyId(@PathVariable() Long id) {

		Optional<College> fetchId = this.collegeService.collegeRepository.findById(id);
		if (fetchId.isEmpty()) {
			logger.error("Failed to get College with " + id);
		} else {
			return fetchId.get();
		}
		return null;
	}

	@PostMapping("/updateadres/{id}")
	public College updateAdressId(@PathVariable() Long id, @RequestBody String Adress) {
		Optional<College> bd = this.collegeService.collegeRepository.findById(id);
		if (bd.isPresent()) {
			College college = bd.get();
			college.setCollegeAdress(Adress);
			return this.collegeService.collegeRepository.save(college);
		}
		return null;
	}

	@PostMapping("/updatemultipleaddress")
	public ResponseEntity<List<College>>  updateAddresess(@RequestBody List<College> addresess) throws Exception {
		// iterate through each id. find it entity
		// then update address to db entity
		// save updated address i.e. db entity
		if(addresess!=null) {
		List<College> colleges = new ArrayList<College>(); // empty array list
		for (College eachCollegeAddress : addresess) {
			// get db entity from database
			Optional<College> optional = this.collegeService.collegeRepository
					.findById(eachCollegeAddress.getCollegeId());
			if (optional.isPresent()) {
				// extract db entity
				College dbCollege = optional.get();
				// update Address
				dbCollege.setCollegeAdress(eachCollegeAddress.getCollegeAdress());
				this.collegeService.collegeRepository.save(dbCollege);
				colleges.add(dbCollege);
				logger.info("record saved succesfully");
			}
		}
		return new ResponseEntity<List<College>>(colleges,HttpStatus.ACCEPTED);
		
		}
		else {
			throw new Exception("Invalid addresses");
		}
}

	@PostMapping("/updateaddresswithmap")
	public ResponseEntity<List<College>>  updateAddreses(@RequestBody Map<String, String> addresess) {
		List<College> colleges = new ArrayList<College>();
		for (String id : addresess.keySet()) {
			
			// get db entity from database
			Optional<College> optional = this.collegeService.collegeRepository.findById(Long.parseLong(id));
			if (optional.isPresent()) {
				// extract db entity
				College dbCollege = optional.get();
				// update Address
				dbCollege.setCollegeAdress(addresess.get(id));
				this.collegeService.collegeRepository.save(dbCollege);
				colleges.add(dbCollege);
			}
		}
		return ResponseEntity.ok(colleges);
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteByID(@PathVariable() Long id) {

		this.collegeService.collegeRepository.deleteById(id);
	}

	@DeleteMapping("/deletebyid")
	public void deleteIt(@PathVariable() Long id) {
		this.collegeService.collegeRepository.deleteById(id);
	}
	
	

	@GetMapping("searchbyname/{collegeName}")
	public College findByCollegeName(@PathVariable() String collegeName)
	{
     return this.collegeService.collegeRepository.findByCollegeName(collegeName);
	}
}
