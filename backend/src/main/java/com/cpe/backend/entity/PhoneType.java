package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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

    private @NonNull String name;

    @OneToMany(fetch = FetchType.EAGER)
    //mappedBy  = "type"
    private Collection<User> rent;

    public void setName(String name){
    	this.name=name;
    }
}