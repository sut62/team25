  package com.cpe.backend;

import com.cpe.backend.entity.Addjob;
import com.cpe.backend.repository.AddjobRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AddjobTests {
    private Validator validator;

    @Autowired
    private AddjobRepository addjobRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6007409_testAddjobSuccess() {
        Addjob addjob = new Addjob();
        addjob.setName("Nuttawan Pluemsoontorn");
        addjob.setIntroduction("hello Wolrd");
        addjob.setEducation("m6/6");
        addjob.setPhone("0123456789");

        addjob = addjobRepository.saveAndFlush(addjob);

        Optional<Addjob> found = addjobRepository.findById(addjob.getId());
        assertEquals("Nuttawan Pluemsoontorn", found.get().getName());
        assertEquals("hello Wolrd", found.get().getIntroduction());
        assertEquals("m6/6", found.get().getEducation());
        assertEquals("0123456789", found.get().getPhone());
    }
    @Test
    void b6007409_testNameMustNotBeNull() {
        Addjob addjob = new Addjob();
       
        addjob.setName(null);
        addjob.setIntroduction("hello Wolrd");
        addjob.setEducation("m6/6");
        addjob.setPhone("0123456789");

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("name", v.getPropertyPath().toString());
    }

    @Test
    void b6007409_testPhoneMinSize() {
        Addjob addjob = new Addjob();
        addjob.setName("Nuttawan Pluemsoontorn");
        addjob.setIntroduction("hello Wolrd");
        addjob.setEducation("m6/6");
        addjob.setPhone("12345678");

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);

        assertEquals(1, result.size());

        ConstraintViolation<Addjob> v = result.iterator().next();
        assertEquals("size must be between 9 and 10", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }
    @Test
    void b6007409_testPhoneMaxSize() {
        Addjob addjob = new Addjob();
        addjob.setName("Nuttawan Pluemsoontorn");
        addjob.setIntroduction("hello Wolrd");
        addjob.setEducation("m6/6");
        addjob.setPhone("12345678901");

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);

        assertEquals(1, result.size());

        ConstraintViolation<Addjob> v = result.iterator().next();
        assertEquals("size must be between 9 and 10", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }
   
    @Test
    void b6007409_testPhonePattern() {
        Addjob addjob = new Addjob();
        addjob.setName("Nuttawan Pluemsoontorn");
        addjob.setIntroduction("hello Wolrd");
        addjob.setEducation("m6/6");
        addjob.setPhone("A234567890");

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Addjob> v = result.iterator().next();
        assertEquals("must match \"^[0-9]*$\"", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }

    @Test
    void b6007409_testIntroductionMustNotBeNull() {
        Addjob addjob = new Addjob();
       
        addjob.setName("Nuttawan Pluemsoontorn");
        addjob.setIntroduction(null);
        addjob.setEducation("m6/6");
        addjob.setPhone("0123456789");

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("introduction", v.getPropertyPath().toString());
    }

    @Test
    void b6007409_testEducationMustNotBeNull() {
        Addjob addjob = new Addjob();
       
        addjob.setName("Nuttawan Pluemsoontorn");
        addjob.setIntroduction("helloooo");
        addjob.setEducation(null);
        addjob.setPhone("0123456789");

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("education", v.getPropertyPath().toString());
    }

 
}