package com.cpe.backend.resume.entity;
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
@Table(name="EDUCATION")
public class Education {
    @Id
    @SequenceGenerator(name="EDUCATION_SEQ",sequenceName="EDUCATION_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EDUCATION_SEQ")
    @Column(name="EDUCATION_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String education_level;


    @OneToMany(fetch = FetchType.EAGER)
    // mappedBy  = "education"
    private Collection<Resume> re;
    
    public void setName(String name) {
		this.education_level = name;
	}
}

