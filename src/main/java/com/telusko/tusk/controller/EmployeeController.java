package com.telusko.tusk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.telusko.tusk.dto.EmployeeDto;
import com.telusko.tusk.entities.Employee;
import com.telusko.tusk.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private  EmployeeService employeeService;
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {
		Employee employee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployeeDetails")
	public List<Employee> getAllEmployeeDetails(){
		return employeeService.getAllEmployeeDetails();
		
	}
	
	@GetMapping("/getEmployeeDetail/{employeeId}")
	public Employee getEmployee(@PathVariable long employeeId) {
		return 	employeeService.getEmployee(employeeId);	
	}
	
	@PutMapping("/updateEmployeeDetail/{employeeId}")
	public ResponseEntity<?> updateEmployee(@PathVariable long employeeId,@RequestBody EmployeeDto employeeDto){
		return employeeService.updateEmployee(employeeId , employeeDto);
		
	}
	
	@DeleteMapping("/deleteEmployeeDetail/{employeeId}")
	public void deleteEmployee(@PathVariable long employeeId) {
		employeeService.deleteEmployee(employeeId);
		 
	}
	
	@GetMapping("getEmployeeByOrganizationId/{organizationId}")
	public List<Employee> getEmployeeByOrganizationId(long organizationId){
		return employeeService.getEmployeeByOrganizationId(organizationId);
		
	}

}
