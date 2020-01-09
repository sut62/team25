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

@Data
@Entity
@NoArgsConstructor
@Table(name="JOB_POST")
public class JobPost {

    @Id
    @SequenceGenerator(name="job_post_seq",sequenceName="job_post_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="job_post_seq")
    @Column(name = "JOB_POST_ID", unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String salary;
    private @NonNull String educationlevel;
    private @NonNull String Other_details;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "POSITION_ID", insertable = true)
    @JsonManagedReference
    private Position position;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Company.class)
    @JoinColumn(name = "COMPANY_ID", insertable = true)
    @JsonManagedReference
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Benefit.class)
    @JoinColumn(name = "BENEFIT_ID", insertable = true)
    @JsonManagedReference
    private Benefit benefit;

    public void setBenefit(Benefit benefit) {
                this.benefit=benefit;
	}

	public void setCompany(Company company) {
                this.company=company;
	}

	public void setPosition(Position position) {
                this.position=position;
        }

	public void setOther(String other_details) {
                this.Other_details=other_details;
	}

	public void setEducationlevel(String educationlevel) {
                this.educationlevel=educationlevel;
	}

	public void setSalary(String salary) {
                this.salary=salary;
	}
}
