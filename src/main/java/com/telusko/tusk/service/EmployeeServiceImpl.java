package com.telusko.tusk.service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.tusk.dto.EmployeeDto;
import com.telusko.tusk.entities.Employee;
import com.telusko.tusk.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee();
		e1.setEmployeeName(employeeDto.getEmployeeName());
		e1.setSalary(employeeDto.getSalary());
		e1.setAddress(employeeDto.getAddress());
		employeeRepository.save(e1);
		return e1;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public ResponseEntity<?> updateEmployee(Long employeeId , EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		try {
			Employee e2 = getEmployee(employeeId);
			e2.setEmployeeName(employeeDto.getEmployeeName());
			e2.setSalary(employeeDto.getSalary());
			e2.setAddress(employeeDto.getAddress());
			employeeRepository.save(e2);
			return new ResponseEntity<Employee>(e2,HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeeByOrganizationId(long organizationId) {
		
		return employeeRepository.findByOrganizationId(organizationId);
	}

}
