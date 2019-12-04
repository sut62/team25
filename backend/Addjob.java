package com.okta.springbootvue.entity;

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

import com.okta.springbootvue.entity.Information;
import com.okta.springbootvue.entity.User;
import com.okta.springbootvue.entity.JobPost;


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
    private @NonNull String introduction;;
    private @NonNull String education;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "User_id", insertable = true)
    @JsonManagedReference
    private  User user;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Information.class)
    @JoinColumn(name = "Information_id", insertable = true)
    @JsonManagedReference
    private Information information;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = JobPost.class)
    @JoinColumn(name = "JobPost_id", insertable = true)
    @JsonManagedReference
    private  JobPost jobPost;

	public void setName(String name) {
        this.name=name;
	}

}