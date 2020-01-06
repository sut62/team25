package com.okta.springbootvue.controller;

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

import com.cpe.backend.entity.Addjob;
import com.cpe.backend.entity.Information;
import com.cpe.backend.entity.entity.User;
import com.cpe.backend.entity.entity.JobPost;

import com.cpe.backend.repository.AddjobRepository;
import com.cpe.backend.repository.InformationRepository;
import com.cpe.backend.repository.UserRepository;
import com.cpe.backend.repository.JobPostRepository;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AddjobController {
    @Autowired
    private final AddjobRepository addjobRepository;
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobPostRepository jobPostRepository;
    
    
    AddjobController(AddjobRepository addjobRepository) {
        this.addjobRepository = addjobRepository;
    }

    @GetMapping("/addjob")
    public Collection<Addjob> Addjobs() {
        return addjobRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/addjob/{name}/{u}/{phone}/{education}/{j}/{i}/{introduction}")
    public Addjob newAddjob(Addjob newAddjob, 
    @PathVariable String name,
    @PathVariable long u,
    @PathVariable String phone,
    @PathVariable String education,
    @PathVariable long j,
    @PathVariable long i,
    @PathVariable String introduction)

    {
        Information information = informationRepository.findById(i);
        User user = userRepository.findById(u);
        JobPost jobPost = jobPostRepository.findById(j);
       
        newAddjob.setName(name);
        newAddjob.setUser(user);
        newAddjob.setPhone(phone);
        newAddjob.setEducation(education);
        newAddjob.setJobPost(jobPost);
        newAddjob.setInformation(information);
        newAddjob.setIntroduction(introduction);
        
        return addjobRepository.save(newAddjob);
    }
}