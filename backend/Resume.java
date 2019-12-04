package com.cpe.backend.resume.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cpe.backend.registercompany.entity.Province;
import com.cpe.backend.registeruser.entity.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Date;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="RESUME")
public class Resume {

    @Id
    @SequenceGenerator(name="resume_seq",sequenceName="resume_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="resume_seq")
    @Column(name = "RESUME_ID", unique = true, nullable = true)
    private @NonNull Long id;
    
    @Column(name="Address")
    private @NonNull String address;

    @Column(name="Birthday")
    private @NonNull Date date;

    @Column(name="Interest")
    private @NonNull String interest;

    @Column(name="Talent")
    private @NonNull String talent;

    @Column(name="University")
    private @NonNull String university;

    @Column(name="Workaddrress")
    private @NonNull String workaddress;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "USER_ID", insertable = true)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Education.class)
    @JoinColumn(name = "EDUCATION_ID", insertable = true)
    private Education education;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Workexperience.class)
    @JoinColumn(name = "WORKEXPERIENCE_ID", insertable = true)
    private Workexperience workexperience;

	public void setUser(User user2) {
        this.user=user2;
	}

	public void setEducation(Education education2) {
        this.education=education2;
	}

	public void setProvince(Province province2) {
        this.province=province2;
	}

	public void setWorkexperience(Workexperience workexperience2) {
        this.workexperience=workexperience2;
	}

	public void setAddress(String address2) {
        this.address=address2;
	}

	public void setBirthday(Date date2) {
        this.date=date2;
	}

	public void setInterest(String interest2) {
    this.interest=interest2;
    }

	public void setTalent(String talent2) {
        this.talent=talent2;
	}

	public void setUniversity(String university2) {
        this.university=university2;
	}

    
}
