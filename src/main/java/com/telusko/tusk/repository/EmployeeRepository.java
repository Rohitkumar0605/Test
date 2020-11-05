package com.telusko.tusk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.tusk.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	List<Employee> findByOrganizationId(long organizationId);

}
