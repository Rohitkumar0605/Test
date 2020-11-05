package com.telusko.tusk.controller;

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
import com.telusko.tusk.dto.OrganizationDto;
import com.telusko.tusk.entities.Organization;
import com.telusko.tusk.service.OrganizationService;

@RestController
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@PostMapping("/createOrganization")
	public ResponseEntity<Organization> createOrganization(@RequestBody OrganizationDto organizationDto) {
		Organization organization = organizationService.createOrganization(organizationDto);
		return new ResponseEntity<Organization>(organization, HttpStatus.OK);

	}

	@GetMapping("/getOrganizationDetail/{organizationId}")
	public Organization getOrganization(@PathVariable long organizationId) {
		return organizationService.getOrganization(organizationId);

	}

	@PutMapping("/updateOrganization/{organizationId}")
	public ResponseEntity<?> updateOrganization(@RequestBody OrganizationDto organizationDto,
			@PathVariable long organizationId) {
		return organizationService.updateOrganization(organizationDto, organizationId);

	}

	@DeleteMapping("deleteOrganization/{organizationId}")
	public void deleteOraganization(@PathVariable long organizationId) {
		organizationService.deleteOraganization(organizationId);
	}

}
