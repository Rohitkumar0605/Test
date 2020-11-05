package com.telusko.tusk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.tusk.entities.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
