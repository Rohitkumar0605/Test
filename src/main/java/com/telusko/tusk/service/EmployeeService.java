package com.telusko.tusk.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.tusk.dto.EmployeeDto;
import com.telusko.tusk.entities.Employee;

@Service
public interface EmployeeService {
	
	Employee createEmployee(EmployeeDto employeeDto);
	Employee getEmployee(Long employeeId);
	ResponseEntity<?> updateEmployee(Long employeeId, EmployeeDto employeeDto);
	void deleteEmployee(Long employeeId);
	List<Employee> getAllEmployeeDetails(); 
	List<Employee> getEmployeeByOrganizationId(long organizationId);

}
