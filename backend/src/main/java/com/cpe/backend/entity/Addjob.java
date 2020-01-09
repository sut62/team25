package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.cpe.backend.entity.Information;
import com.cpe.backend.entity.Gender;
import com.cpe.backend.entity.Position;;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Addjob")
public class Addjob {
    @Id
    @SequenceGenerator(name="Addjob_seq",sequenceName="Addjob_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Addjob_seq")
    @Column(name = "Addjob_id", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String name;
    private @NonNull String phone;
    private @NonNull String introduction;
    private @NonNull String education;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "GENDER_ID", insertable = true)
    @JsonManagedReference
    private  Gender gender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Information.class)
    @JoinColumn(name = "Information_id", insertable = true)
    @JsonManagedReference
    private Information information;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "POSITION_ID", insertable = true)
    @JsonManagedReference
    private  Position position;

	public void setName(String name) {
        this.name=name;
	}

}