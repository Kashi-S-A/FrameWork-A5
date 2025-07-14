package com.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.datajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	// custom queries
//	@Query("select s from Student s where s.phone=:stuPhone")
//	public List<Student> getStudentByPhone(Long stuPhone);//naming based

//	@Query(value = "select * from student_info", nativeQuery = true)//nativeQuery : SQL
	@Query("select s from Student s where s.phone=?1")
	public List<Student> getStudentByPhone(Long phone);// index based

//	@Query("select s from Student s where s.phone=:stuPhone and s.name=:stuName")
//	public List<Student> getStudentByPhoneAndName(Long stuPhone, String stuName);// naming based

	@Query("select s from Student s where s.phone=?1 and s.name=?2")
	public List<Student> getStudentByPhoneAndName(Long phone, String name);// naming based

	// custom method : you need to follow method naming convention, method name
	// should start from
	// findBy();
	public List<Student> findByPhone(Long phone);

	List<Student> findByNameContaining(String name);

	List<Student> findBySidGreaterThanEquals(Long sid);

	List<Student> findByNameAndPhone(String name, Long phone);
}
