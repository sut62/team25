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
@Table(name="BENEFIT")
public class Benefit {
    @Id
    @SequenceGenerator(name="BENEFIT_SEQ",sequenceName="BENEFIT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BENEFIT_SEQ")
    @Column(name="BENEFIT_ID",unique = true, nullable = true)

    private @NonNull Long id;
    private @NonNull String name;

    @OneToMany(fetch = FetchType.EAGER)
   
    private Collection<JobPost> job;

   

}
