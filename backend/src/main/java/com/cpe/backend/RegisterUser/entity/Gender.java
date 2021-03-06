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
@Table(name="GENDER")
public class Gender {
	
	@Id
	@SequenceGenerator(name="GENDER_seq",sequenceName="GENDER_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENDER_seq")
	@Column(name="GENDER_ID",unique = true, nullable = true)
	private @NonNull Long id;

	@NotNull
	private @NonNull String name;

	public void setName(String name){
    	this.name=name;
    }
}
