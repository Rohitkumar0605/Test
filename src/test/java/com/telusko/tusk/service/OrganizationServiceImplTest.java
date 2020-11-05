package com.telusko.tusk.service;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.telusko.tusk.dto.OrganizationDto;
import com.telusko.tusk.entities.Organization;
import com.telusko.tusk.repository.OrganizationRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class OrganizationServiceImplTest {

	@InjectMocks
	OrganizationServiceImpl organizationServiceImpl;

	@Mock
	OrganizationRepository organizationRepository;

	static OrganizationDto organizationDto = new OrganizationDto();
	static Organization organization = new Organization();
	static Optional<Organization> organization1 = Optional.empty();

	@BeforeClass
	public static void setUp() {
		organizationDto.setOrganizationName("Stellapps");
		organization.setOrganizationId(111L);
		organization.setOrganizationName(organizationDto.getOrganizationName());
		
		organization1 = Optional.of(organization);
	}

	@Test
	public void testCreateOrganization() {
		Organization orgAct = organizationServiceImpl.createOrganization(organizationDto);
		Assert.assertEquals("Stellapps", orgAct.getOrganizationName());

	}
	
	@Test
	public void testgetOrganization() {
		Mockito.when(organizationRepository.findById(111L)).thenReturn(organization1);
		Organization actOrg = organizationServiceImpl.getOrganization(111L);
		Assert.assertEquals("Stellapps", actOrg.getOrganizationName());
		
	}

}
