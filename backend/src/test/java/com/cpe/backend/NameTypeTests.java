package com.cpe.backend;

import com.cpe.backend.entity.NameType;
import com.cpe.backend.repository.NameTypeRepository;

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
public class NameTypeTests {

    private Validator validator;

    @Autowired
    private NameTypeRepository nameTypeRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6026493_testNameTypeNotnull() {
        NameType nameType = new NameType();
        nameType.setName(null);
        Set<ConstraintViolation<NameType>> result = validator.validate(nameType);
        assertEquals(1, result.size());
        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("name", result.iterator().next().getPropertyPath().toString());
    }
    
    @Test
    void b6026493_testInsertOK() {
        NameType nameType = new NameType();
        nameType.setName("นาย");
        nameType = nameTypeRepository.saveAndFlush(nameType);
        Optional<NameType> found = nameTypeRepository.findById(nameType.getId());
        assertEquals(nameType.getName(), found.get().getName());
    }
}


















