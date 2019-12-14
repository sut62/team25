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

@Data
@Entity
@NoArgsConstructor
@Table(name="COMPANY")
public class Company {

    @Id
    @SequenceGenerator(name="COMPANY_seq",sequenceName="COMPANY_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="COMPANY_seq")
    @Column(name = "COMPANY_ID", unique = true, nullable = true)
    private @NonNull Long id;

    
    private @NonNull String name;

    
    private @NonNull String password;
    
    
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

        public void setType(CompanyType type) {
                this.type = type;
	}

	public void setSize(CompanySize size) {
                this.size = size;
	}
	public void setProvince(Province province) {
                this.province = province;
        }
        
        public void setName(String name) {
                this.name=name;
	}

	public void setEmail(String email) {
                this.email=email;
	}

	public void setPassword(String password) {
                this.password = password;
        }
       
}