package com.okta.springbootvue.controller;

import com.okta.springbootvue.entity.Information;
import com.okta.springbootvue.repository.InformationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class InformationController {

    @Autowired
    private final InformationRepository informationRepository;

    public InformationController(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @GetMapping("/information")
    public Collection<Information> Informations() {
        return informationRepository.findAll().stream().collect(Collectors.toList());
    }

}