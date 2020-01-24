package com.cpe.backend.RegisterCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cpe.backend.RegisterCompany.entity.CompanyType;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
	CompanyType findById(long id);
}