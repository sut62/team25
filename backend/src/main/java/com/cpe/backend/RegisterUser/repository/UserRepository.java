package com.cpe.backend.RegisterUser.repository;

import com.cpe.backend.RegisterUser.entity.User;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestResource
public
interface UserRepository extends JpaRepository<User, Long> {
	User findById(long id);
    @Query( value = "SELECT * FROM User z WHERE z.email = :email and z.password = :password",nativeQuery = true)
    Collection<User> findCheck(@Param("email") String email,@Param("password") String password);
}