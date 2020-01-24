package com.cpe.backend;

import com.cpe.backend.RegisterCompany.entity.CompanySize;
import com.cpe.backend.RegisterCompany.repository.CompanySizeRepository;

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
public class CompanySizeTests {

    private Validator validator;

    @Autowired
    private CompanySizeRepository companySizeRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6007553_testCompanySizeNotnull() {
        CompanySize companySize = new CompanySize();
        companySize.setName(null);

        Set<ConstraintViolation<CompanySize>> result = validator.validate(companySize);

        assertEquals(1, result.size());

        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("name", result.iterator().next().getPropertyPath().toString());
    }
    
    @Test
    void b6007553_testInsertOK() {
        CompanySize companySize = new CompanySize();
        companySize.setName("วิสาหกิจขนาดใหญ่");

        companySize = companySizeRepository.saveAndFlush(companySize);

        Optional<CompanySize> found = companySizeRepository.findById(companySize.getId());
        assertEquals(companySize.getName(), found.get().getName());
    }
}