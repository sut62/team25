package com.cpe.backend;

import com.cpe.backend.entity.PhoneType;
import com.cpe.backend.repository.PhoneTypeRepository;

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
public class PhoneTypeTests {

    private Validator validator;

    @Autowired
    private PhoneTypeRepository phoneTypeRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6026493_testNameTypeNotnull() {
        PhoneType phoneType = new PhoneType();
        phoneType.setName(null);
        Set<ConstraintViolation<PhoneType>> result = validator.validate(phoneType);
        assertEquals(1, result.size());
        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("name", result.iterator().next().getPropertyPath().toString());
    }
    
    @Test
    void b6026493_testInsertOK() {
        PhoneType phoneType = new PhoneType();
        phoneType.setName("บริษัท");
        phoneType = phoneTypeRepository.saveAndFlush(phoneType);
        Optional<PhoneType> found = phoneTypeRepository.findById(phoneType.getId());
        assertEquals(phoneType.getName(), found.get().getName());
    }
}


















