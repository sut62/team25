package com.cpe.backend.repository;

import com.cpe.backend.entity.CompanyType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
	CompanyType findById(long id);
}