package com.cpe.backend;

import com.cpe.backend.RegisterCompany.entity.Company;
import com.cpe.backend.RegisterCompany.repository.CompanyRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
public class CompanyTests {

    private Validator validator;

    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    void b6007553_testSuccess() {
        Company c1 = new Company();
        c1.setName("SUT Company");
        c1.setPassword("0123456789");
        c1.setEmail("sut@mail.com");

        c1 = companyRepository.saveAndFlush(c1);

        Optional<Company> found = companyRepository.findById(c1.getId());
        assertEquals("SUT Company", found.get().getName());
        assertEquals("0123456789", found.get().getPassword());
        assertEquals("sut@mail.com", found.get().getEmail());
    }

    @Test
    void b6007553_testNameNull() {
        Company c2 = new Company();
        c2.setName(null);
        c2.setPassword("0123456789");
        c2.setEmail("sut@mail.com");


        Set<ConstraintViolation<Company>> result = validator.validate(c2);

        
        assertEquals(1, result.size());

       
        ConstraintViolation<Company> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("name", v.getPropertyPath().toString());
    }

    @Test
    void b6007553_testNameMinSize() {
        Company c3 = new Company();
        c3.setName("SUT"); 
        c3.setPassword("0123456789");
        c3.setEmail("sut@mail.com");

        Set<ConstraintViolation<Company>> result = validator.validate(c3);

        
        assertEquals(1, result.size());

        
        ConstraintViolation<Company> v = result.iterator().next();
        assertEquals("size must be between 6 and 50", v.getMessage());
        assertEquals("name", v.getPropertyPath().toString());
    }

    @Test
    void b6007553_testNameMaxSize() {
        Company c4 = new Company();
        c4.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"); 
        c4.setPassword("0123456789");
        c4.setEmail("sut@mail.com");

        Set<ConstraintViolation<Company>> result = validator.validate(c4);

        
        assertEquals(1, result.size());

        
        ConstraintViolation<Company> v = result.iterator().next();
        assertEquals("size must be between 6 and 50", v.getMessage());
        assertEquals("name", v.getPropertyPath().toString());
    }

    @Test
    void b6007553_testNotEmail() {
        Company c5 = new Company();
        c5.setName("SUT Company"); 
        c5.setPassword("0123456789");
        c5.setEmail("sutmail");

        Set<ConstraintViolation<Company>> result = validator.validate(c5);
        
        assertEquals(1, result.size());

        ConstraintViolation<Company> v = result.iterator().next();

        assertEquals("must match \"^(.+)@(.+)$\"", v.getMessage());
        assertEquals("email", v.getPropertyPath().toString());
    }

    @Test
    void b6007553_testPasswordMinSize() {
        Company c6 = new Company();
        c6.setName("SUT Company"); 
        c6.setPassword("012345678");
        c6.setEmail("sut@mail.com");

        Set<ConstraintViolation<Company>> result = validator.validate(c6);

        
        assertEquals(1, result.size());

        
        ConstraintViolation<Company> v = result.iterator().next();
        assertEquals("size must be between 10 and 20", v.getMessage());
        assertEquals("password", v.getPropertyPath().toString());
    }

    @Test
    void b6007553_testPasswordMaxSize() {
        Company c7 = new Company();
        c7.setName("SUT Company"); 
        c7.setPassword("012345678901234567890");
        c7.setEmail("sut@mail.com");

        Set<ConstraintViolation<Company>> result = validator.validate(c7);

        
        assertEquals(1, result.size());

        
        ConstraintViolation<Company> v = result.iterator().next();
        assertEquals("size must be between 10 and 20", v.getMessage());
        assertEquals("password", v.getPropertyPath().toString());
    }

    @Test
    void b6007553_testPasswordNull() {
        Company c2 = new Company();
        c2.setName("SUT Company");
        c2.setPassword(null);
        c2.setEmail("sut@mail.com");


        Set<ConstraintViolation<Company>> result = validator.validate(c2);

        
        assertEquals(1, result.size());

       
        ConstraintViolation<Company> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("password", v.getPropertyPath().toString());
    }

    @Test
    void b6007553_testEmailNull() {
        Company c2 = new Company();
        c2.setName("SUTCompany");
        c2.setPassword("0123456789");
        c2.setEmail(null);


        Set<ConstraintViolation<Company>> result = validator.validate(c2);

        
        assertEquals(1, result.size());

       
        ConstraintViolation<Company> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("email", v.getPropertyPath().toString());
    }

}


















