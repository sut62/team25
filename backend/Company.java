package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="COMPANY")
public class Company {

    @Id
    @SequenceGenerator(name="company_seq",sequenceName="company_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="company_seq")
    @Column(name = "COMPANY_ID", unique = true, nullable = true)
    private @NonNull Long id;

    @Column(name="TimeRegister")
    private @NonNull Date TimeRegister;

    @Column(name="Name")
    private @NonNull String name;

    @Column(name="Pass")
    private @NonNull String pass;
    
    @Column(name="Email")
    private @NonNull String email;


  

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanySize.class)
    @JoinColumn(name = "SIZE_ID", insertable = true)
    private CompanySize size;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyType.class)
    @JoinColumn(name = "TYPE_ID", insertable = true)
    private CompanyType type;

    public void setType(CompanyType type2) {
        this.type = type2;
	}

	public void setSize(CompanySize size2) {
        this.size = size2;
	}
	public void setProvince(Province province2) {
        this.province = province2;
    }
	public void setTimeRegister(Date date) {
        this.TimeRegister = date;
	}

	public void setCompany(String name) {
                this.name=name;
        }
        public void setName(String name) {
                this.name=name;
	}

	public void setEmail(String email2) {
                this.email=email2;
	}

		public void setPass(String pass2) {
                this.pass = pass2;
                }
       
}