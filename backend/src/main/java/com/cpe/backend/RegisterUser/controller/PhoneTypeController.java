package com.cpe.backend.RegisterUser.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.cpe.backend.RegisterUser.entity.PhoneType;
import com.cpe.backend.RegisterUser.repository.PhoneTypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PhoneTypeController {

    @Autowired
    private final PhoneTypeRepository phoneTypeRepository;

    public PhoneTypeController(PhoneTypeRepository phoneTypeRepository) {
        this.phoneTypeRepository = phoneTypeRepository;
    }

    @GetMapping("/phoneType")
    public Collection<PhoneType> PhoneTypes() {
        return phoneTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}