package com.ca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ca.dao.CounselorDao;
import com.ca.dto.CounselorDTO;
import com.ca.dto.LoginDTO;
import com.ca.rs.ResponseStructor;

@Service
public class CounselorServiceImpl implements CounselorService {

	@Autowired
	private CounselorDao counselorDao;

	@Override
	public ResponseEntity<?> registerCounselor(CounselorDTO dto) {
		boolean ispresent = counselorDao.findByEmail(dto.getEmail());
		if (ispresent) {
			// TODO : already exist
			return new ResponseEntity<String>("Already registered", HttpStatus.BAD_REQUEST);
		} else {
			// TODO : save and return msg
			counselorDao.save(dto);

			ResponseStructor<String> rs = new ResponseStructor<String>("Registered Successfully with email ",
					dto.getEmail(), HttpStatus.CREATED);

			return new ResponseEntity<ResponseStructor<String>>(rs, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<String> login(LoginDTO loginDTO) {
		boolean login = counselorDao.findByEmailAndPassword(loginDTO);

		if (login) {
			// TODO : succ
			return new ResponseEntity<String>("Logged in Successfully", HttpStatus.OK);
		} else {
			// TODO : invalid
			return new ResponseEntity<String>("Invalid credentials", HttpStatus.BAD_REQUEST);
		}
	}
}
