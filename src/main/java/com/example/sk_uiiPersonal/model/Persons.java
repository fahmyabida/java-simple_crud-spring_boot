package com.example.sk_uiiPersonal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("unused")
@Entity
@Table(name = "persons")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
//        allowGetters = true)

public class Persons implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	private int id_person;
	
	@Column(nullable = false, length =  45)
	private String name;
	
	@Column(nullable = false)
	private Date birth_date;

	@Column(nullable = false, length =  45)
	private String birth_place;
	
	@Column(nullable = false, length =  45)
	private String address;
	
	@Column(nullable = false, length =  1)
	private int gender;
	
	@Column(length =  15)
	private String phone_number;
	
	//private Integer id_major;
	
//	private Integer id_division;
	@ManyToOne
	@JoinColumn (name="id_division")
//	@JsonBackReference
	private Divisions divisions;
	
	@ManyToOne
	@JoinColumn (name="id_major")
//	@JsonBackReference
	private Majors majors;

	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getBirth_place() {
		return birth_place;
	}

	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Divisions getDivisions() {
		return divisions;
	}

	public void setDivisions(Divisions divisions) {
		this.divisions = divisions;
	}

	public Majors getMajors() {
		return majors;
	}

	public void setMajors(Majors majors) {
		this.majors = majors;
	}
}