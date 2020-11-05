package com.telusko.tusk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.telusko.tusk.dto.EmployeeDto;
import com.telusko.tusk.entities.Employee;
import com.telusko.tusk.repository.EmployeeRepository;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Mock
	EmployeeRepository employeeRepository;

	static EmployeeDto employeeDto = new EmployeeDto();
	static Employee emp = new Employee();
	static List<Employee> lst = new ArrayList<Employee>();
	static Optional<Employee> emp1 = Optional.empty();
	static ResponseEntity<?> expectedvalue2 = new ResponseEntity<Employee>(emp, HttpStatus.OK);
	

	@BeforeClass
	public static void setUp() {
		employeeDto.setEmployeeName("Rohit");
		employeeDto.setSalary(1200);
		employeeDto.setAddress("BLR");
		employeeDto.setOrganizationId(111L);
		emp.setEmployeeId(11L);
		emp.setEmployeeName(employeeDto.getEmployeeName());
		emp.setSalary(employeeDto.getSalary());
		emp.setAddress(employeeDto.getAddress());
		emp.setOrganizationId(employeeDto.getOrganizationId());
		lst.add(emp);
		
		emp1 = Optional.of(emp);

	}

	@Test
	public void testCreateEmployee() {
		Employee actEmp = employeeServiceImpl.createEmployee(employeeDto);
		Assert.assertEquals("Rohit", actEmp.getEmployeeName());
	}

	@Test
	public void testGetEmployee() {
		Mockito.when(employeeRepository.findById(11L)).thenReturn(emp1);
		Employee actEmp2 = employeeServiceImpl.getEmployee(11L);
		Assert.assertEquals("Rohit", actEmp2.getEmployeeName());
	}

	@Test
	public void testUpdateEmployee() {
		Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
		ResponseEntity<?> actval2 = employeeServiceImpl.updateEmployee(emp.getEmployeeId(), employeeDto);
		Assert.assertEquals(expectedvalue2, actval2);

	}

	@Test
	public void testGetAllEmployeeDetails() {
		Mockito.when(employeeRepository.findAll()).thenReturn(lst); 
		List<Employee> actval1 = employeeServiceImpl.getAllEmployeeDetails();
		Assert.assertEquals(1, actval1.size());
	}
	
	@Test
	public void testGetEmployeeByOrganizationId() {
		Mockito.when(employeeRepository.findByOrganizationId(employeeDto.getOrganizationId())).thenReturn(lst);
		List<Employee> actval3 = employeeServiceImpl.getEmployeeByOrganizationId(employeeDto.getOrganizationId());
		Assert.assertEquals(1, actval3.size());

	}

}
