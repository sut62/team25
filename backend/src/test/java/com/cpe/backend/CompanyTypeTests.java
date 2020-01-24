package com.cpe.backend;

import com.cpe.backend.RegisterCompany.entity.CompanyType;
import com.cpe.backend.RegisterCompany.repository.CompanyTypeRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
public class CompanyTypeTests {

    private Validator validator;

    @Autowired
    private CompanyTypeRepository companyTypeRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6007553_testCompanyTypeNotnull() {
        CompanyType companyType = new CompanyType();
        companyType.setName(null);

        Set<ConstraintViolation<CompanyType>> result = validator.validate(companyType);

        assertEquals(1, result.size());

        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("name", result.iterator().next().getPropertyPath().toString());
    }
    
    @Test
    void b6007553_testInsertOK() {
        CompanyType companyType = new CompanyType();
        companyType.setName("องค์กรธุรกิจ");

        companyType = companyTypeRepository.saveAndFlush(companyType);

        Optional<CompanyType> found = companyTypeRepository.findById(companyType.getId());
        assertEquals(companyType.getName(), found.get().getName());
    }
}