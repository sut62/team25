package com.cpe.backend.RegisterCompany.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name="COMPANYSIZE")
public class CompanySize {
	
	@Id
	@SequenceGenerator(name="SIZE_SEQ",sequenceName="SIZE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SIZE_SEQ")
	@Column(name="SIZE_ID",unique = true, nullable = true)
	private @NonNull Long id;

	@NotNull
	private @NonNull String name;

	public void setName(String name) {
        this.name=name;
	}
}