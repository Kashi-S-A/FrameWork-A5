package com.ca.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ca.dao.CounselorDao;
import com.ca.dao.EnquiryDao;
import com.ca.dto.EnquiryRequestDTO;
import com.ca.entity.Counselor;
import com.ca.entity.Enquiry;
import com.ca.enums.ClassMode;
import com.ca.enums.Course;
import com.ca.exception.CounselorNotFound;
import com.ca.util.EmailService;

import jakarta.mail.MessagingException;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryDao enquiryDao;

	@Autowired
	private CounselorDao counselorDao;

	@Autowired
	private EmailService mailService;

	@Override
	public ResponseEntity<String> add(Integer cid, EnquiryRequestDTO dto) throws MessagingException {
		Counselor counselor = counselorDao.findById(cid).orElseThrow(() -> new CounselorNotFound());
		Optional<Enquiry> enq = enquiryDao.findByPhone(dto.getPhone());

		if (enq.isPresent()) {
			return new ResponseEntity<String>(
					"Enquiry is already taken by counselor : " + enq.get().getCounselor().getName(), HttpStatus.OK);
		} else {
			Enquiry enquiry = new Enquiry();
			BeanUtils.copyProperties(dto, enquiry);
			enquiry.setCounselor(counselor);
			enquiryDao.add(enquiry);
			mailService.sendConfirmMail(enquiry.getEmail(), enquiry.getName(), enquiry.getCourse());
			return new ResponseEntity<String>("Enquiry Added Successfully", HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<String> updateClassMode(Integer id, ClassMode classMode) {
		Enquiry enq = enquiryDao.findById(id);
		enq.setClassMode(classMode);
		Enquiry saved = enquiryDao.add(enq);
		return new ResponseEntity<String>("Class Mode updated to : " + saved.getClassMode(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Page<Enquiry>> fetchByCourse(Course course, Integer pageNumber) {
		return new ResponseEntity<Page<Enquiry>>(enquiryDao.fetchByCourse(course, pageNumber), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Integer eid) {
		enquiryDao.findById(eid);
		enquiryDao.deleteEnq(eid);
		return new ResponseEntity<String>("Deleted Successfull", HttpStatus.OK);
	}
}
