package com.citi.sachin.springbootlearning.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.sachin.springbootlearning.domain.entity.Passport;
import com.citi.sachin.springbootlearning.service.PassportService;

@RestController
@RequestMapping(value = "/passport")
public class PassportController {

	@Autowired
	PassportService passportService;

	@GetMapping("/fetchall")
	public List<Passport> getPassport() {
		return this.passportService.passportRepository.findAll();
	}

//	@GetMapping("/{id}")
//	public Passport getPassport(@PathVariable() Long id) 
//		Optional<Passport> optional = this.passportService.passportRepository.findById(id);
//		if (optional.isPresent()) {
//			return optional.get();
//		} else {
//			return null;
//		}
//	}

	@PostMapping("/save")
	public List<Passport> savePassport(@RequestBody() List<Passport> passport) {
		this.passportService.passportRepository.saveAll(passport);
		return passport;
	}

	@DeleteMapping("/{id}")
	public void deletePassport(@PathVariable() Long id) {
		this.passportService.passportRepository.deleteById(id);
	}

	@PostMapping("/multiplepassport")

	public List<Passport> upadateMultiple(@RequestBody() List<Passport> numbers) {
		for (Passport eachPassportNumber : numbers) {
			Optional<Passport> optional = this.passportService.passportRepository.findById(eachPassportNumber.getId());

			if (optional.isPresent()) {
				Passport pass = optional.get();
				pass.setNumber(eachPassportNumber.getNumber());
				this.passportService.passportRepository.save(pass);
			}

		}

		return numbers;
	}
//
//	@PostMapping("/save")
//	public List<Passport> savePassport1(@RequestBody() List<Passport> passport) {
//		this.passportService.passportRepository.saveAll(passport);
//		return passport;
//	}
	


}
