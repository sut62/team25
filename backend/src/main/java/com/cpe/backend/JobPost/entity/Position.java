package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name="POSITION")
public class Position {

    @Id
    @SequenceGenerator(name="POSITION_SEQ",sequenceName="POSITION_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="POSITION_SEQ")
    @Column(name = "POSITION_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @NotNull
    @Column(name="name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER)

    private Set<JobPost> Position;

    public void setName(String name) {
        this.name=name;
	}

}