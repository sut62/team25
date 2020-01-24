package com.cpe.backend.RegisterCompany.entity;

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
@Table(name="COMPANYTYPE")
public class CompanyType {
	
	@Id
	@SequenceGenerator(name="TYPE_SEQ",sequenceName="TYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TYPE_SEQ")
	@Column(name="TYPE_ID",unique = true, nullable = true)
	private @NonNull Long id;

	@NotNull
	private @NonNull String name;
	
	public void setName(String name) {
        this.name=name;
	}
}
