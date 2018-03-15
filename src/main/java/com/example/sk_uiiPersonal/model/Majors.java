package com.example.sk_uiiPersonal.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "majors")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"persons"})

public class Majors implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_major;
	
	@Column(nullable = false, length =  45)//nullable default true
	private String name_major;
	
	@Column(length =  45)
	private String desc_major;
	
	private Integer id_faculty;
	
	
	@OneToMany(mappedBy = "majors")
	private Set<Persons> persons = new HashSet<>();
//	private List<Persons> persons;


	public int getId_major() {
		return id_major;
	}


	public void setId_major(int id_major) {
		this.id_major = id_major;
	}


	public String getName_major() {
		return name_major;
	}


	public void setName_major(String name_major) {
		this.name_major = name_major;
	}


	public String getDesc_major() {
		return desc_major;
	}


	public void setDesc_major(String desc_major) {
		this.desc_major = desc_major;
	}


	public Integer getId_faculty() {
		return id_faculty;
	}


	public void setId_faculty(Integer id_faculty) {
		this.id_faculty = id_faculty;
	}


	public Set<Persons> getPersons() {
		return persons;
	}


	public void setPersons(Set<Persons> persons) {
		this.persons = persons;
	}
}
