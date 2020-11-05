package com.telusko.tusk.dto;

public class EmployeeDto {

	private String employeeName;
	private double salary;
	private String address;
	private long organizationId;

	public EmployeeDto(String employeeName, double salary, String address, long organizationId) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
		this.address = address;
		this.organizationId = organizationId;
	}

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeName=" + employeeName + ", salary=" + salary + ", address=" + address
				+ ", organizationId=" + organizationId + "]";
	}

}
