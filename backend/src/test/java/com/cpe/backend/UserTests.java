package com.cpe.backend;

import com.cpe.backend.entity.User;
import com.cpe.backend.repository.UserRepository;

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
public class UserTests {
    private Validator validator;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

     @Test
    void b6026493_testUserInsertSuccess() {
        User user = new User();
        user.setName("Nuttawan Pluemsoontorn");
        user.setPassword("12345678");
        user.setEmail("amp@gmail.com");
        user.setPhone("0123456789");

        user = userRepository.saveAndFlush(user);

        Optional<User> found = userRepository.findById(user.getId());
        assertEquals("Nuttawan Pluemsoontorn", found.get().getName());
        assertEquals("12345678", found.get().getPassword());
        assertEquals("amp@gmail.com", found.get().getEmail());
        assertEquals("0123456789", found.get().getPhone());
    }

    @Test
    void b6026493_testUserNameMustNotBeNull() {
        User user = new User();
       
        user.setName(null);
        user.setEmail("amp@gmail.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");

        Set<ConstraintViolation<User>> result = validator.validate(user);
       
       assertEquals(1, result.size());

       ConstraintViolation<User> v = result.iterator().next();
       assertEquals("must not be null", v.getMessage());
       assertEquals("name", v.getPropertyPath().toString());
    }

    @Test
    void b6026493_testUserEmailMustHaveAddress() {
        User user = new User();

        user.setName("Nuttawan Pluemsoontorn");
        user.setEmail("amp.com");
        user.setPassword("12345678");
        user.setPhone("0123456789");

        Set<ConstraintViolation<User>> result = validator.validate(user);

        assertEquals(1, result.size());

        ConstraintViolation<User> v = result.iterator().next();
        assertEquals("must be a well-formed email address", v.getMessage());
        assertEquals("email", v.getPropertyPath().toString());
    }

    @Test
    void b6026493_testPhoneMinSize() {
        User user = new User();
        user.setName("Nuttawan Pluemsoontorn");
        user.setEmail("amp@gmail.com");
        user.setPassword("12345678");
        user.setPhone("12345678");

        Set<ConstraintViolation<User>> result = validator.validate(user);

        
        assertEquals(1, result.size());

        
        ConstraintViolation<User> v = result.iterator().next();
        assertEquals("size must be between 9 and 10", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }

    @Test
    void b6026493_testPhoneMaxSize() {
        User user = new User();
        user.setName("Nuttawan Pluemsoontorn");
        user.setEmail("amp@gmail.com");
        user.setPassword("12345678");
        user.setPhone("12345678901");

        Set<ConstraintViolation<User>> result = validator.validate(user);

        
        assertEquals(1, result.size());

        
        ConstraintViolation<User> v = result.iterator().next();
        assertEquals("size must be between 9 and 10", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }

    @Test
    void b6026493_testPhone() {
        User user = new User();
        user.setName("Nuttawan Pluemsoontorn");
        user.setEmail("amp@gmail.com");
        user.setPassword("12345678");
        user.setPhone("A234567890");

        Set<ConstraintViolation<User>> result = validator.validate(user);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<User> v = result.iterator().next();
        assertEquals("must match \"^[0-9]*$\"", v.getMessage());
        assertEquals("phone", v.getPropertyPath().toString());
    }

    

    
}