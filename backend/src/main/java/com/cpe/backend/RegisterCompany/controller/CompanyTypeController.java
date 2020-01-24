package com.cpe.backend.RegisterCompany.controller;

import com.cpe.backend.RegisterCompany.entity.CompanyType;
import com.cpe.backend.RegisterCompany.repository.CompanyTypeRepository;
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
public class CompanyTypeController {

    @Autowired
    private final CompanyTypeRepository companyTypeRepository;

    public CompanyTypeController(CompanyTypeRepository companyTypeRepository) {
        this.companyTypeRepository = companyTypeRepository;
    }

    @GetMapping("/companyType")
    public Collection<CompanyType> CompanyTypes() {
        return companyTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/companyType/{id}")
    public Optional<CompanyType> CompanyTypes(@PathVariable Long id) {
        Optional<CompanyType> companyType = companyTypeRepository.findById(id);
        return companyType;
    }
}