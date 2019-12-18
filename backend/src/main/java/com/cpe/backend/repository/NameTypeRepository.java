package com.cpe.backend.repository;

import com.cpe.backend.entity.NameType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface NameTypeRepository extends JpaRepository<NameType, Long> {
	NameType findById(long id);
}