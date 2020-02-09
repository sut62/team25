package com.cpe.backend.RegisterCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;

import com.cpe.backend.RegisterCompany.entity.CompanySize;
import com.cpe.backend.RegisterCompany.entity.CompanyType;
import com.cpe.backend.RegisterCompany.entity.Province;
import com.cpe.backend.RegisterCompany.entity.Company;
import com.cpe.backend.RegisterCompany.repository.CompanySizeRepository;
import com.cpe.backend.RegisterCompany.repository.CompanyTypeRepository;
import com.cpe.backend.RegisterCompany.repository.ProvinceRepository;
import com.cpe.backend.RegisterCompany.repository.CompanyRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController

public class CompanyController {
    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private CompanyTypeRepository companyTypeRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private CompanySizeRepository companySizeRepository;

    CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/checkcompany/{email}/{password}")
    public Collection<Company> getCheck(@PathVariable("email") String email,@PathVariable("password") String password) {
        return companyRepository.findCheck(email,password);
    }
    
    @GetMapping("/company")
    public Collection<Company> Companys() {
        return companyRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/company/{id}")
    public Optional<Company> Companys(@PathVariable Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company;
    }

    @PostMapping("/company/{name}/{email}/{password}/{size_id}/{province_id}/{type_id}")
    public Company newCompany(Company newCompany,
   
    @PathVariable String name,
    @PathVariable String email,
    @PathVariable String password,
    @PathVariable long size_id,
    @PathVariable long type_id,
    @PathVariable long province_id) {
   
    CompanySize size = companySizeRepository.findById(size_id);
    CompanyType type = companyTypeRepository.findById(type_id);
    Province province = provinceRepository.findById(province_id);
    
    newCompany.setName(name);
    newCompany.setSize(size);
    newCompany.setType(type);
    newCompany.setProvince(province);
    newCompany.setEmail(email);
    newCompany.setPassword(password);
    
    return companyRepository.save(newCompany);
    
    }
}