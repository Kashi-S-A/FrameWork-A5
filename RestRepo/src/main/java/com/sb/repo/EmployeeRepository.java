package com.sb.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sb.entity.Employee;

@RepositoryRestResource(path = "employee") // exposes the rest api
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Page<Employee> findByNameContaining(@Param(value = "name") String name, Pageable pageable);
}
