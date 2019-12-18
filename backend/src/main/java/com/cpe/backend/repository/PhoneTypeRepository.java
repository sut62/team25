package com.cpe.backend.repository;

import com.cpe.backend.entity.PhoneType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PhoneTypeRepository extends JpaRepository<PhoneType, Long> {
	PhoneType findById(long id);
}