package com.example.first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEnnity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "full_name")
	private String full_name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "birth")
	private String birth;

	@Column(name = "math")
	private double math;

	@Column(name = "english")
	private double english;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassesEntity classsE;

	public StudentEnnity() {

	}

	public StudentEnnity(Long id, String full_name, String phone, String birth, double math, double english) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.phone = phone;
		this.birth = birth;
		this.math = math;
		this.english = english;
	}

	public ClassesEntity getClasssE() {
		return classsE;
	}

	public void setClasssE(ClassesEntity classsE) {
		this.classsE = classsE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}
}
