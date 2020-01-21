package com.cpe.backend;

import com.cpe.backend.entity.Addjob;
import com.cpe.backend.repository.AddjobRepository;
import com.cpe.backend.entity.Information;
import com.cpe.backend.repository.InformationRepository;

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
public class InformationTests {

    private Validator validator;

    @Autowired
    private InformationRepository informationRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6008970_testInformationNotnull() {
        Information information = new Information();
        information.setInformation_type(null);
        Set<ConstraintViolation<Information>> result = validator.validate(information);
        assertEquals(1, result.size());
        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("Information_type", result.iterator().next().getPropertyPath().toString());
    }
    @Test
    void b6007409_testTypeMustGreaterEqual4() {
        Information information = new Information();
        information.setInformation_type("123");
        Set<ConstraintViolation<Information>> result = validator.validate(information);
        assertEquals(1, result.size());
        assertEquals("size must be between 4 and 30", result.iterator().next().getMessage());
        assertEquals("Information_type", result.iterator().next().getPropertyPath().toString());
    }
    @Test
    void b6007409_testTypeMustLessEqual30() {
        Information information = new Information();
        information.setInformation_type("1234567890123456789012345678901");
        Set<ConstraintViolation<Information>> result = validator.validate(information);
        assertEquals(1, result.size());
        assertEquals("size must be between 4 and 30", result.iterator().next().getMessage());
        assertEquals("Information_type", result.iterator().next().getPropertyPath().toString());
    }
    @Test
    void b6007409_testInsertStatusOK() {
        Information information = new Information();
        information.setInformation_type("Website");
        information = informationRepository.saveAndFlush(information);
        Optional<Information> found = informationRepository.findById(information.getInformation_id());
        assertEquals(information.getInformation_type(), found.get().getInformation_type());
    }
}


















