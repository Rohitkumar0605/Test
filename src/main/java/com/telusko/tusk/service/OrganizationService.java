package com.telusko.tusk.service;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.telusko.tusk.dto.OrganizationDto;
import com.telusko.tusk.entities.Organization;

@Service
public interface OrganizationService {
	
	Organization createOrganization(OrganizationDto organizationDto);
	Organization getOrganization(long organizationId);
	ResponseEntity<?> updateOrganization(OrganizationDto organizationDto ,long organizationId);
	void deleteOraganization(long organizationId);


}
