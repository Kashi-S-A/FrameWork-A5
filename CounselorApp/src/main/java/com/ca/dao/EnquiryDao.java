package com.ca.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ca.entity.Enquiry;
import com.ca.enums.Course;
import com.ca.exception.EnquiryNotFound;
import com.ca.repository.EnquiryRepository;

@Repository
public class EnquiryDao {

	@Autowired
	private EnquiryRepository enquiryRepository;

	public Optional<Enquiry> findByPhone(Long phone) {
		return enquiryRepository.findByPhone(phone);
	}

	public Enquiry add(Enquiry enquiry) {
		return enquiryRepository.save(enquiry);
	}

	public Enquiry findById(Integer id) {
		return enquiryRepository.findById(id).orElseThrow(() -> new EnquiryNotFound());
	}

	public Page<Enquiry> fetchByCourse(Course course, Integer pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber - 1, 10);

		return enquiryRepository.findByCourse(course, pageable);
	}

	public void deleteEnq(Integer eid) {
		enquiryRepository.deleteById(eid);
	}
}
