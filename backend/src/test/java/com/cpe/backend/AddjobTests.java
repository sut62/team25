  package com.cpe.backend;

import com.cpe.backend.Addjob.entity.Addjob;
import com.cpe.backend.Addjob.repository.AddjobRepository;
import com.cpe.backend.Addjob.entity.Information;
import com.cpe.backend.Addjob.repository.InformationRepository;
import com.cpe.backend.RegisterUser.entity.Gender;
import com.cpe.backend.RegisterUser.repository.GenderRepository;
import com.cpe.backend.JobPost.entity.Position;
import com.cpe.backend.JobPost.repository.PositionRepository;

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
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private PositionRepository positionRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    void b6007409_testAddjobSuccess() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone("0952350700");
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(position);

        addjob = addjobRepository.saveAndFlush(addjob);

        Optional<Addjob> found = addjobRepository.findById(addjob.getAddjob_id());
        assertEquals("Nanticha Boonkla", found.get().getName());
        assertEquals("hello World", found.get().getIntroduction());
        assertEquals("m6/6", found.get().getEducation());
        assertEquals("0952350700", found.get().getPhone());
        assertEquals(gender, found.get().getGender());
        assertEquals(information, found.get().getInformation());
        assertEquals(position, found.get().getPosition());
    }
   @Test //ชื่อห้ามว่าง
    void b6007409_testNameMustNotBeNull() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName(null);
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone("0952350700");
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("name", v.getPropertyPath().toString());
    }

   @Test //เบอร์โทรห้ามว่าง
    void b6007409_testPhoneMustNotBeNull() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone(null);
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("phone", v.getPropertyPath().toString());
    }
    @Test //introduction ห้ามว่าง
    void b6007409_testIntroductionMustNotBeNull() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction(null);
        addjob.setEducation("m6/6");
        addjob.setPhone("0952350700");
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("introduction", v.getPropertyPath().toString());
    }

    @Test //education ห้ามว่าง
    void b6007409_testEducationMustNotBeNull() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation(null);
        addjob.setPhone("0952350700");
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("education", v.getPropertyPath().toString());
    }

    @Test //Phone ห้ามน้อยกว่า9
    void b6007409_testPhoneMustSizeLessThan9() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone("12345678");
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);

        assertEquals(1, result.size());

        ConstraintViolation<Addjob> v = result.iterator().next();
        assertEquals("size must be between 9 and 10", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }
    @Test //Phone ห้ามมากกว่า10
    void b6007409_testPhoneMustSizeGreatThan10() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone("12345678901");
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);

        assertEquals(1, result.size());

        ConstraintViolation<Addjob> v = result.iterator().next();
        assertEquals("size must be between 9 and 10", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }
   
    @Test //ห้ามมีตัวอักษรใน Phone และต้องมี 10 ตัว
    void b6007409_testPhonePattern() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone("A123456789");
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Addjob> v = result.iterator().next();
        assertEquals("must match \"^[0-9]*$\"", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }
    @Test //gender ห้ามว่าง
    void b6007409_testGenderMustNotBeNull() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone("0952350700");
        addjob.setGender(null);
        addjob.setInformation(information);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("gender", v.getPropertyPath().toString());
    }
    @Test //information ห้ามว่าง
    void b6007409_testInformationMustNotBeNull() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone("0952350700");
        addjob.setGender(gender);
        addjob.setInformation(null);
        addjob.setPosition(position);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("information", v.getPropertyPath().toString());
    }
    @Test //position ห้ามว่าง
    void b6007409_testPositionMustNotBeNull() {
        Addjob addjob = new Addjob();
        Information information = informationRepository.findById(2);
        Position position = positionRepository.findById(2);
        Gender gender = genderRepository.findById(2);
        addjob.setName("Nanticha Boonkla");
        addjob.setIntroduction("hello World");
        addjob.setEducation("m6/6");
        addjob.setPhone("0952350700");
        addjob.setGender(gender);
        addjob.setInformation(information);
        addjob.setPosition(null);

        Set<ConstraintViolation<Addjob>> result = validator.validate(addjob);
       
       assertEquals(1, result.size());

       ConstraintViolation<Addjob> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("position", v.getPropertyPath().toString());
    }
    
}