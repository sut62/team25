package com.cpe.backend.RegisterCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.cpe.backend.RegisterCompany.entity.Province;;

@RepositoryRestResource
public
interface ProvinceRepository extends JpaRepository<Province, Long> {
	Province findById(long id);
}
