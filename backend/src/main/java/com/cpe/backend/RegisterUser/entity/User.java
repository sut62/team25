package com.cpe.backend.RegisterUser.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@Entity
@NoArgsConstructor
@Table(name="USER")
public class User {

    @Id
    @SequenceGenerator(name="USER_seq",sequenceName="USER_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USER_seq")
    @Column(name = "USER_ID", unique = true, nullable = true)
    private @NonNull Long id;
    
    @NotNull
    private @NonNull String name;

    @NotNull
    @Email
    private @NonNull String email;

    @NotNull
    @Size(min=8,max=20)
    private @NonNull String password;

    @NotNull
    @Size(min=9,max=10)
     @Pattern(regexp = "^[0-9]*$")
    private @NonNull String phone;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = NameType.class)
    @JoinColumn(name = "NAMETYPE_ID", insertable = true)
    @JsonManagedReference
    private NameType nameType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "GENDER_ID", insertable = true)
    @JsonManagedReference
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PhoneType.class)
    @JoinColumn(name = "PHONETYPE_ID", insertable = true)
    @JsonManagedReference
    private PhoneType phoneType;


    

    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public void setNameType(NameType nameType) {
        this.nameType = nameType;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}