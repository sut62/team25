package com.cpe.backend.repository;

import com.cpe.backend.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface InformationRepository extends JpaRepository<Information, Long> {
    Information findById(long id);
}