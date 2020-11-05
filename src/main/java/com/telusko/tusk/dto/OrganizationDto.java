package com.telusko.tusk.dto;

public class OrganizationDto {

	private String organizationName;

	public OrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrganizationDto(String organizationName) {
		super();
		this.organizationName = organizationName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	@Override
	public String toString() {
		return "OrganizationDto [organizationName=" + organizationName + "]";
	}

}
