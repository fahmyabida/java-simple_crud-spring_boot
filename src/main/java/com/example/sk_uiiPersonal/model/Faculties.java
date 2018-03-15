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


@SuppressWarnings("unused")
@Entity
@Table(name = "faculties")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
//        allowGetters = true)

public class Faculties implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_faculty;
	
	@Column(nullable = false, length =  45)//nullable default true
	private String name_faculty;
	
	@Column(length =  45)
	private String desc_faculty;

	public int getId_faculty() {
		return id_faculty;
	}

	public void setId_faculty(int id_faculty) {
		this.id_faculty = id_faculty;
	}

	public String getName_faculty() {
		return name_faculty;
	}

	public void setName_faculty(String name_faculty) {
		this.name_faculty = name_faculty;
	}

	public String getDesc_faculty() {
		return desc_faculty;
	}

	public void setDesc_faculty(String desc_faculty) {
		this.desc_faculty = desc_faculty;
	}
}
