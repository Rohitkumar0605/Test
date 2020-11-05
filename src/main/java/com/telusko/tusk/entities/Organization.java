package com.telusko.tusk.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization_table")
public class Organization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "organizationId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long organizationId;
	@Column(name = "organizationName")
	private String organizationName;

	public Organization() {
		super();
	}

	public Organization(long organizationId, String organizationName) {
		super();
		this.organizationId = organizationId;
		this.organizationName = organizationName;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", organizationName=" + organizationName + "]";
	}
	
	
}
