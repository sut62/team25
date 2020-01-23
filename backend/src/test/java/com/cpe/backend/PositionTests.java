package com.cpe.backend;

import com.cpe.backend.entity.JobPost;
import com.cpe.backend.repository.JobPostRepository;
import com.cpe.backend.entity.Position;
import com.cpe.backend.repository.PositionRepository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
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
public class PositionTests {

    private Validator validator;

    @Autowired
    private PositionRepository positionRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void b6020156_testPositionNotnull() {
        Position position = new Position();
        position.setName(null);
        Set<ConstraintViolation<Position>> result = validator.validate(position);
        assertEquals(1, result.size());
        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("name", result.iterator().next().getPropertyPath().toString());
    }

    @Test
    void b6020156_testPositionSuccess() {
        Position position = new Position();
        position.setName("พนักงานบัญชี");
        position = positionRepository.saveAndFlush(position);
        Optional<Position> found = positionRepository.findById(position.getId());
        assertEquals(position.getName(), found.get().getName());
    }

}
