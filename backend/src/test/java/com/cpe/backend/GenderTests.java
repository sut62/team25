package com.cpe.backend;

import com.cpe.backend.RegisterUser.entity.Gender;
import com.cpe.backend.RegisterUser.repository.GenderRepository;

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
public class GenderTests {

    private Validator validator;

    @Autowired
    private GenderRepository genderRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6026493_testGenderNotnull() {
        Gender gender = new Gender();
        gender.setName(null);
        Set<ConstraintViolation<Gender>> result = validator.validate(gender);
        assertEquals(1, result.size());
        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("name", result.iterator().next().getPropertyPath().toString());
    }
    
    @Test
    void b6026493_testInsertOK() {
        Gender gender = new Gender();
        gender.setName("ชาย");
        gender = genderRepository.saveAndFlush(gender);
        Optional<Gender> found = genderRepository.findById(gender.getId());
        assertEquals(gender.getName(), found.get().getName());
    }
}


















