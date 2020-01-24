package com.cpe.backend.RegisterUser.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name="PHONETYPE")
public class PhoneType {
    
    @Id
    @SequenceGenerator(name="PHONETYPE_seq",sequenceName="PHONETYPE_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PHONETYPE_seq")
    @Column(name="PHONETYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    @NotNull
    private @NonNull String name;

    public void setName(String name){
    	this.name=name;
    }
}