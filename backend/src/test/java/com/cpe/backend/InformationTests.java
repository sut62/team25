package com.cpe.backend;

import com.cpe.backend.Addjob.entity.Addjob;
import com.cpe.backend.Addjob.repository.AddjobRepository;
import com.cpe.backend.Addjob.entity.Information;
import com.cpe.backend.Addjob.repository.InformationRepository;

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
    void b6007409_testInformationPattren(){
        Information information = new Information();
        information.setInformation_type("WebsiteAAA123");
        Set<ConstraintViolation<Information>> result = validator.validate(information);
        assertEquals(1, result.size());
        ConstraintViolation<Information> message = result.iterator().next();
        assertEquals("must match \"[a-zA-Z]{1,50}$\"",message.getMessage());
        assertEquals("Information_type",message.getPropertyPath().toString());
    }
    @Test
    void b6007409_testInformationNotnull() {
        Information information = new Information();
        information.setInformation_type(null);
        Set<ConstraintViolation<Information>> result = validator.validate(information);
        assertEquals(1, result.size());
        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("Information_type", result.iterator().next().getPropertyPath().toString());
    }
    @Test
    void b6007409_testInformationMustGreaterEqual4() {
        Information information = new Information();
        information.setInformation_type("ttt");
        Set<ConstraintViolation<Information>> result = validator.validate(information);
        assertEquals(1, result.size());
        assertEquals("size must be between 4 and 30", result.iterator().next().getMessage());
        assertEquals("Information_type", result.iterator().next().getPropertyPath().toString());
    }
    @Test
    void b6007409_testInformationMustLessEqual30() {
        Information information = new Information();
        information.setInformation_type("Arhhassdaassadasdasdasdadasdasdasdasdasd");
        Set<ConstraintViolation<Information>> result = validator.validate(information);
        assertEquals(1, result.size());
        assertEquals("size must be between 4 and 30", result.iterator().next().getMessage());
        assertEquals("Information_type", result.iterator().next().getPropertyPath().toString());
    }
    @Test
    void b6007409_testInformationSuccess() {
        Information information = new Information();
        information.setInformation_type("Website");
        information = informationRepository.saveAndFlush(information);
        Optional<Information> found = informationRepository.findById(information.getId());
        assertEquals(information.getInformation_type(), found.get().getInformation_type());
    }
   
}


















