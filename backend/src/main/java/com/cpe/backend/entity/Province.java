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
@Table(name="PROVINCE")
public class Province {
	@Id
	@SequenceGenerator(name="PROVINCE_SEQ",sequenceName="PROVINCE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Province_seq")
	@Column(name="PROVINCE_ID",unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String	name;

	@OneToMany(fetch = FetchType.EAGER)
	// mappedBy  = "Provincer"
	private Collection<Company> register;

}
