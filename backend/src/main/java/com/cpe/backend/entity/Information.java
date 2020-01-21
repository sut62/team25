package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name="Information")
public class Information {
    @Id    
    @SequenceGenerator(name="Information_SEQ",sequenceName="Information_SEQ")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Information_SEQ")

    @Column(name="Information_id",unique = true, nullable = true)
    private @NonNull Long information_id;
    
    @NotNull
    @Size(min=4, max=30)
    @Column(name="Information_type")
    private String Information_type;
    @OneToMany(fetch = FetchType.EAGER)
	
	private Set<Addjob> Information;

	public void setName(String name){
        this.Information_type=name;
    }
    
}