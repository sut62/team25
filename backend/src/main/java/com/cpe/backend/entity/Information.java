package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Information")
public class Information {

    @Id
    @SequenceGenerator(name="Information_seq",sequenceName="Information_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Information_seq")  
    @Column(name = "Information_id", unique = true, nullable = true)
        private @NonNull Long id; 

        private @NonNull String information_type;

	public void setName(String name) {
        this.information_type=name;
	}

    
}