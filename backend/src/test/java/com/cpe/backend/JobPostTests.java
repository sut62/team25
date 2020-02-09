package com.cpe.backend;

import com.cpe.backend.JobPost.entity.JobPost;
import com.cpe.backend.JobPost.repository.JobPostRepository;


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
public class JobPostTests {

    private Validator validator;

    @Autowired
    private JobPostRepository JobPostRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6020156_testSalarydetailsNotnull() {
        JobPost j = new JobPost();
        j.setSalarydetails(null);
        j.setEducationlevel("Ph.D");
        j.setOther("บุคลิกภาพดี");

        Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();

        assertEquals("must not be null", v.getMessage());
        assertEquals("salarydetails", v.getPropertyPath().toString());
    }
    @Test
    void b6020156_testEducationlevelNotnull() {
        JobPost j = new JobPost();
        j.setSalarydetails("12000บาท");
        j.setEducationlevel(null);
        j.setOther("บุคลิกภาพดี");

        Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();

        assertEquals("must not be null", v.getMessage());
        assertEquals("educationlevel", v.getPropertyPath().toString());
    }
    @Test
    void b6020156_testOtherNotnull() {
        JobPost j = new JobPost();
        j.setSalarydetails("12000บาท");
        j.setEducationlevel("Ph.D");
        j.setOther(null);

        Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();

        assertEquals("must not be null", v.getMessage());
        assertEquals("Other_details", v.getPropertyPath().toString());
    }

    @Test
    void b6020156_testeducationlevelName() {
        JobPost j = new JobPost();
        j.setEducationlevel("Ph/D");
        j.setSalarydetails("12000บาท");
        j.setOther("บุคลิกภาพดี");
        Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();

        assertEquals("must match \"^[.A-Za-z0-9ก-ฮะ-๙]*$\"", v.getMessage());
        assertEquals("educationlevel", v.getPropertyPath().toString());
    }
    @Test
    void b6020156_testOtherName() {
        JobPost j = new JobPost();
        j.setEducationlevel("Ph.D");
        j.setSalarydetails("12000บาท");
        j.setOther("บุคลิกภาพดี/*-+");
        Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();

        assertEquals("must match \"^[.A-Za-z0-9ก-ฮะ-๙]*$\"", v.getMessage());
        assertEquals("Other_details", v.getPropertyPath().toString());
    }
    @Test
    void b6020156_testSalaryMustSizeLessThan20() {
        JobPost j = new JobPost();
        j.setSalarydetails("100000000000000000000");
        j.setEducationlevel("Ph.D");
        j.setOther("บุคลิกภาพดี");
     Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();
        assertEquals("size must be between 4 and 20",  v.getMessage());
        assertEquals("salarydetails", v.getPropertyPath().toString());
    }
    @Test
    void b6020156_testSalaryMustSizeGreatThan4() {
        JobPost j = new JobPost();
        j.setSalarydetails("10");
        j.setEducationlevel("Ph.D");
        j.setOther("บุคลิกภาพดี");
        Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();
        assertEquals("size must be between 4 and 20",  v.getMessage());
        assertEquals("salarydetails", v.getPropertyPath().toString());
    }
    @Test
    void b6020156_testEducationlevelMustSizeLessThan3() {
        JobPost j = new JobPost();
        j.setSalarydetails("10000บาท");
        j.setEducationlevel("Ph");
        j.setOther("บุคลิกภาพดี");
        Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();
        assertEquals("size must be between 3 and 20",  v.getMessage());
        assertEquals("educationlevel", v.getPropertyPath().toString());
    }
    @Test
    void b6020156_testEducationlevelMustSizeGreatThan20() {
        JobPost j = new JobPost();
        j.setSalarydetails("10000บาท");
        j.setEducationlevel("Ph.DandPh.DandPh.DandPh.DandPh.DandPh.D");
        j.setOther("บุคลิกภาพดี");
        Set<ConstraintViolation<JobPost>> result = validator.validate(j);
        assertEquals(1, result.size());

        ConstraintViolation<JobPost> v = result.iterator().next();
        assertEquals("size must be between 3 and 20",  v.getMessage());
        assertEquals("educationlevel", v.getPropertyPath().toString());
    }
    @Test
    void b6020156_testSuccess() {
        JobPost j = new JobPost();
        j.setEducationlevel("Ph.D");
        j.setSalarydetails("160000บาท");
        j.setOther("หล่อ");

        j = JobPostRepository.saveAndFlush(j);
 
        Optional<JobPost> found = JobPostRepository.findById(j.getId());
        assertEquals("Ph.D", found.get().getEducationlevel());
        assertEquals("160000บาท", found.get().getSalarydetails());
        assertEquals("หล่อ", found.get().getOther_details());
    }

    }
