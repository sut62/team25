package com.cpe.backend.RegisterUser.controller;

import com.cpe.backend.RegisterUser.entity.NameType;
import com.cpe.backend.RegisterUser.repository.NameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class NameTypeController {

    @Autowired
    private final NameTypeRepository nameTypeRepository;

    public NameTypeController(NameTypeRepository nameTypeRepository) {
        this.nameTypeRepository = nameTypeRepository;
    }

    @GetMapping("/nameType")
    public Collection<NameType> NameTypes() {
        return nameTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}