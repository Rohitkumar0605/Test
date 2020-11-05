package com.telusko.tusk.service;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.tusk.dto.OrganizationDto;
import com.telusko.tusk.entities.Organization;
import com.telusko.tusk.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public Organization createOrganization(OrganizationDto organizationDto) {
		// TODO Auto-generated method stub
		Organization organization = new Organization();
		organization.setOrganizationName(organizationDto.getOrganizationName());
		organizationRepository.save(organization);
		return organization;
	}

	@Override
	public Organization getOrganization(long organizationId) {
		return organizationRepository.findById(organizationId).get();
	}

	@Override
	public ResponseEntity<?> updateOrganization(OrganizationDto organizationDto, long organizationId) {
		try {
			Organization o1 = getOrganization(organizationId);
			o1.setOrganizationName(organizationDto.getOrganizationName());
			organizationRepository.save(o1);
			return new ResponseEntity<Organization>(o1, HttpStatus.OK);
		} catch (NoSuchElementException e1) {
			return new ResponseEntity<Organization>(HttpStatus.NOT_FOUND);

		}
	}

	@Override
	public void deleteOraganization(long organizationId) {
		organizationRepository.deleteById(organizationId);
	}

}
