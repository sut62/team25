package com.cpe.backend.RegisterCompany.repository;

import com.cpe.backend.RegisterCompany.entity.Company;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestResource

public
interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findById(long id);
    @Query( value = "SELECT * FROM Company z WHERE z.email  = :email and z.password = :password",nativeQuery = true)
   Collection<Company> findCheck(@Param("email") String email,@Param("password") String password);
}