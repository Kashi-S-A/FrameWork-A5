package com.ca.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ca.repository.EnquiryRepository;

@Repository
public class EnquiryDao {

	@Autowired
	private EnquiryRepository enquiryRepository;
}
