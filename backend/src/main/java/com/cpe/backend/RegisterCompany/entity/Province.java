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
@Table(name="PROVINCE")
public class Province {

	@Id
	@SequenceGenerator(name="PROVINCE_SEQ",sequenceName="PROVINCE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Province_seq")
	@Column(name="PROVINCE_ID",unique = true, nullable = true)
	private @NonNull Long id;

	@NotNull
	private @NonNull String	name;

	public void setName(String name) {
        this.name=name;
	}
}
