package com.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ca.dto.EnquiryRequestDTO;
import com.ca.entity.Enquiry;
import com.ca.enums.ClassMode;
import com.ca.enums.Course;
import com.ca.service.EnquiryService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@PostMapping("/{cid}")
	public ResponseEntity<String> addEnquiry(@PathVariable Integer cid, @RequestBody EnquiryRequestDTO dto) throws MessagingException {
		return enquiryService.add(cid, dto);
	}

	@PutMapping("/classMode/{id}")
	public ResponseEntity<String> updateClassMode(@PathVariable Integer id, @RequestParam ClassMode classMode) {
		return enquiryService.updateClassMode(id, classMode);
	}

	// update phone
	// update status
	// update Course

	@GetMapping("/course")
	public ResponseEntity<Page<Enquiry>> fetchByCourse(@RequestParam Course course,@RequestParam Integer pageNumber) {
		return enquiryService.fetchByCourse(course,pageNumber);
	}
	
	//fetch By status
	
	@DeleteMapping("/{eid}")
	public ResponseEntity<String> deleteEnById(@PathVariable Integer eid){
		return enquiryService.deleteById(eid);
	}

}
