package com.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ca.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

}
