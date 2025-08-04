package com.ca.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.ca.dto.EnquiryRequestDTO;
import com.ca.entity.Enquiry;
import com.ca.enums.ClassMode;
import com.ca.enums.Course;

import jakarta.mail.MessagingException;

public interface EnquiryService {

	ResponseEntity<String> add(Integer cid, EnquiryRequestDTO dto) throws MessagingException;

	ResponseEntity<String> updateClassMode(Integer id, ClassMode classMode);

	ResponseEntity<Page<Enquiry>> fetchByCourse(Course course, Integer pageNumber);

	ResponseEntity<String> deleteById(Integer eid);

}
