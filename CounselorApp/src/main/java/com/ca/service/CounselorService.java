package com.ca.service;

import org.springframework.http.ResponseEntity;

import com.ca.dto.CounselorDTO;
import com.ca.dto.LoginDTO;

public interface CounselorService {

	ResponseEntity<?> registerCounselor(CounselorDTO dto);

	ResponseEntity<String> login(LoginDTO loginDTO);

}
