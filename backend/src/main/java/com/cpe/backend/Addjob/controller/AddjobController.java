package com.cpe.backend.Addjob.controller;

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

import com.cpe.backend.Addjob.entity.Addjob;
import com.cpe.backend.RegisterUser.entity.Gender;
import com.cpe.backend.Addjob.entity.Information;
import com.cpe.backend.JobPost.entity.Position;

import com.cpe.backend.Addjob.repository.AddjobRepository;
import com.cpe.backend.Addjob.repository.InformationRepository;
import com.cpe.backend.RegisterUser.repository.GenderRepository;
import com.cpe.backend.JobPost.repository.PositionRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AddjobController {
    @Autowired
    private final AddjobRepository addjobRepository;
    @Autowired
    private InformationRepository informationRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private PositionRepository positionRepository;
    
    AddjobController(AddjobRepository addjobRepository) {
        this.addjobRepository = addjobRepository;
    }

    @GetMapping("/addjob")
    public Collection<Addjob> Addjobs() {
        return addjobRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/addjob/{name}/{gender_id}/{phone}/{education}/{position_id}/{information_id}/{introduction}")
    public Addjob newAddjob(Addjob newAddjob, 
    @PathVariable String name,
    @PathVariable long gender_id,
    @PathVariable String phone,
    @PathVariable String education,
    @PathVariable long position_id,
    @PathVariable long information_id,
    @PathVariable String introduction)

    {
        Information information = informationRepository.findById(information_id);
        Gender gender = genderRepository.findById(gender_id);
        Position position = positionRepository.findById(position_id);
       
        newAddjob.setName(name);
        newAddjob.setGender(gender);
        newAddjob.setPhone(phone);
        newAddjob.setEducation(education);
        newAddjob.setPosition(position);
        newAddjob.setInformation(information);
        newAddjob.setIntroduction(introduction);
        
        return addjobRepository.save(newAddjob);
    }
}