package com.cpe.backend.RegisterCompany.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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

    @NotNull
    @Size(min=6,max=50)
    private @NonNull String name;

    @NotNull
    @Size(min=10,max=20)
    private @NonNull String password;

    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$")
    private @NonNull String email;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    @JsonManagedReference
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanySize.class)
    @JoinColumn(name = "SIZE_ID", insertable = true)
    @JsonManagedReference
    private CompanySize size;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyType.class)
    @JoinColumn(name = "TYPE_ID", insertable = true)
    @JsonManagedReference
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