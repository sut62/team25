package com.cpe.backend.Addjob.repository;

import com.cpe.backend.Addjob.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface InformationRepository extends JpaRepository<Information, Long> {
    Information findById(long id);
}