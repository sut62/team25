package com.cpe.backend.repository;

import com.cpe.backend.entity.CompanySize;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface CompanySizeRepository extends JpaRepository<CompanySize, Long> {
	CompanySize findById(long id);
}