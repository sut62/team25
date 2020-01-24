package com.cpe.backend;

import com.cpe.backend.RegisterCompany.entity.Province;
import com.cpe.backend.RegisterCompany.repository.ProvinceRepository;

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
public class ProvinceTests {

    private Validator validator;

    @Autowired
    private ProvinceRepository provinceRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6007553_testProvinceNotnull() {
        Province province = new Province();
        province.setName(null);

        Set<ConstraintViolation<Province>> result = validator.validate(province);

        assertEquals(1, result.size());

        assertEquals("must not be null", result.iterator().next().getMessage());
        assertEquals("name", result.iterator().next().getPropertyPath().toString());
    }
    
    @Test
    void b6007553_testInsertOK() {
        Province province = new Province();
        province.setName("วิสาหกิจขนาดใหญ่");

        province = provinceRepository.saveAndFlush(province);

        Optional<Province> found = provinceRepository.findById(province.getId());
        assertEquals(province.getName(), found.get().getName());
    }
}