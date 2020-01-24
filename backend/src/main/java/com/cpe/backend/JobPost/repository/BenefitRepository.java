package com.cpe.backend.JobPost.repository;

import com.cpe.backend.JobPost.entity.Benefit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface BenefitRepository extends JpaRepository<Benefit, Long> {
	Benefit findById(long id);
}
