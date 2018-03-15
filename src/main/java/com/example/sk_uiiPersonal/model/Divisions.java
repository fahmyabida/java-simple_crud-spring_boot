package com.example.sk_uiiPersonal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("unused")
@Entity
@Table(name = "divisions")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"persons"})

public class Divisions implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_division;
	
	@Column(nullable = false, length =  45) //nullable defalut true
	private String name_division;
	
	@Column(length =  45)
	private String desc_division;
	
	@OneToMany(mappedBy = "divisions")
	private Set<Persons> persons = new HashSet<>();

	public int getId_division() {
		return id_division;
	}

	public void setId_division(int id_division) {
		this.id_division = id_division;
	}

	public String getName_division() {
		return name_division;
	}

	public void setName_division(String name_division) {
		this.name_division = name_division;
	}

	public String getDesc_division() {
		return desc_division;
	}

	public void setDesc_division(String desc_division) {
		this.desc_division = desc_division;
	}

	public Set<Persons> getPersons() {
		return persons;
	}

	public void setPersons(Set<Persons> persons) {
		this.persons = persons;
	}
	
}
