package com.ca.dao;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ca.dto.CounselorDTO;
import com.ca.dto.LoginDTO;
import com.ca.entity.Counselor;
import com.ca.repository.CounselorRepository;

@Repository
public class CounselorDao {

	@Autowired
	private CounselorRepository counselorRepository;

	public boolean findByEmail(String email) {
		return counselorRepository.findByEmail(email).isPresent();
	}

	public void save(CounselorDTO dto) {

		Counselor counselor = new Counselor();

		BeanUtils.copyProperties(dto, counselor);

		counselorRepository.save(counselor);
	}

	public boolean findByEmailAndPassword(LoginDTO loginDTO) {
		return counselorRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword()).isPresent();
	}
}
