package com.cpe.backend;

import com.cpe.backend.entity.JobPost;
import com.cpe.backend.repository.JobPostRepository;
import com.cpe.backend.entity.Benefit;
import com.cpe.backend.repository.BenefitRepository;


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
public class BenefitTests {

    private Validator validator;

    @Autowired
    private BenefitRepository benefitRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void b6020156_testBenefitNotnull() {
        Benefit benefit = new Benefit();
        benefit.setName(null);
        Set<ConstraintViolation<Benefit>> result = validator.validate(benefit);
        assertEquals(1, result.size());
        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("name", result.iterator().next().getPropertyPath().toString());
    }
   /* @Test
    void b6007409_testPositionPattren(){
        Position position = new Position();
        position.setName("พนักงานบัญ+ชี");
        Set<ConstraintViolation<Position>> result = validator.validate(position);
        assertEquals(1, result.size());
        ConstraintViolation<Position> message = result.iterator().next();
        assertEquals("must match \"^[A-Za-z0-9ก-ฮะ-๙]*$\"",message.getMessage());
        assertEquals("name",message.getPropertyPath().toString());
    }*/

    @Test
    void b6020156_testBenefitSuccess() {
        Benefit benefit = new Benefit();
        benefit.setName("รถส่วนตัว");
        benefit = benefitRepository.saveAndFlush(benefit);
        Optional<Benefit> found = benefitRepository.findById(benefit.getId());
        assertEquals(benefit.getName(), found.get().getName());
    }

}