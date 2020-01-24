package com.cpe.backend.RegisterCompany.controller;

import com.cpe.backend.RegisterCompany.entity.CompanySize;
import com.cpe.backend.RegisterCompany.repository.CompanySizeRepository;
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
public class CompanySizeController {

    @Autowired
    private final CompanySizeRepository companySizeRepository;

    public CompanySizeController(CompanySizeRepository companySizeRepository) {
        this.companySizeRepository = companySizeRepository;
    }

    @GetMapping("/companySize")
    public Collection<CompanySize> CompanySizes() {
        return companySizeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/companySize/{id}")
    public Optional<CompanySize> CompanySizes(@PathVariable Long id) {
        Optional<CompanySize> companySize = companySizeRepository.findById(id);
        return companySize;
    }

}