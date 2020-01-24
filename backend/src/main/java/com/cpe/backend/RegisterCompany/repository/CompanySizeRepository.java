package com.cpe.backend.RegisterCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cpe.backend.RegisterCompany.entity.CompanySize;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CompanySizeRepository extends JpaRepository<CompanySize, Long> {
	CompanySize findById(long id);
}