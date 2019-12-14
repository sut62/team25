package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

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
	private @NonNull String name;

	@OneToMany(fetch = FetchType.EAGER)
	// mappedBy  = "rentCustomer"
	private Collection<User> rent;
}
