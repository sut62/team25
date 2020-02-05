package com.cpe.backend.Addjob.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cpe.backend.JobPost.entity.Position;
import com.cpe.backend.RegisterUser.entity.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table(name="Addjob")
public class Addjob {
    @Id
    @SequenceGenerator(name="Addjob_seq",sequenceName="Addjob_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Addjob_seq")
    @Column(name = "Addjob_id", unique = true, nullable = true)
    private @NonNull Long Addjob_id;

    @NotNull
    private @NonNull String name;

    @NotNull
    @Size(min=9,max=10)
    @Pattern(regexp = "^[0-9]*$")
    private @NonNull String phone;

    @NotNull
    @Size(min=6,max=50)
    private @NonNull String introduction;

    @NotNull
    private @NonNull String education;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "GENDER_ID", insertable = true)
    @JsonManagedReference
    @NotNull
    private  Gender gender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Information.class)
    @JoinColumn(name = "Information_id", insertable = true)
    @JsonManagedReference
    @NotNull
    private Information information;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "POSITION_ID", insertable = true)
    @JsonManagedReference
    @NotNull
    private  Position position;

	public void setName(String name) {
        this.name=name;
        }
    
        public void setInformation(Information information) {
        this.information=information;
        }

        public void setGender(Gender gender) {
        this.gender=gender;
        }

        public void setPosition(Position position) {
        this.position=position;
        }

        public void setPhone(String phone) {
        this.phone=phone;
        }

        public void setEducation(String education) {
        this.education=education;
        }

        public void setIntroduction(String introduction) {
        this.introduction=introduction;
        }
}