package com.cpe.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.cpe.backend.entity.Gender;
import com.cpe.backend.entity.NameType;
import com.cpe.backend.entity.PhoneType;
import com.cpe.backend.entity.User;

import com.cpe.backend.repository.GenderRepository;
import com.cpe.backend.repository.NameTypeRepository;
import com.cpe.backend.repository.PhoneTypeRepository;
import com.cpe.backend.repository.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserController {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private NameTypeRepository nameTypeRepository;
    @Autowired
    private PhoneTypeRepository phoneTypeRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/checkuser/{emails}/{passwords}")
    public Collection<User> getCheck(@PathVariable("emails") String email, @PathVariable("passwords") String password) {
        return userRepository.findCheck(email,password);
    }

    @GetMapping("/user")
    public Collection<User> Users() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/user/{name}/{email}/{password}/{phone}/{nameType_id}/{gender_id}/{phoneType_id}")
    public User newUser(User newUser,
        @PathVariable String name,
        @PathVariable String email,
        @PathVariable String password,
        @PathVariable String phone,
    @PathVariable long nameType_id,
    @PathVariable long gender_id,
    @PathVariable long phoneType_id) {
    //VideoRental newVideoRental = new VideoRental();
    NameType nameType = nameTypeRepository.findById(gender_id);
    Gender gender = genderRepository.findById(nameType_id);
    PhoneType phoneType = phoneTypeRepository.findById(phoneType_id);

    newUser.setNameType(nameType); 
    newUser.setName(name); 
    newUser.setGender(gender);
    newUser.setEmail(email); 
    newUser.setPassword(password); 
    newUser.setPhoneType(phoneType);
    newUser.setPhone(phone); 

    return userRepository.save(newUser); //บันทึก Objcet ชื่อ VideoRental
    
    }
}