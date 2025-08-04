package com.ca.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ca.entity.Enquiry;
import com.ca.enums.Course;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	Optional<Enquiry> findByPhone(Long phone);

	Page<Enquiry> findByCourse(Course course, Pageable pageable);

}
