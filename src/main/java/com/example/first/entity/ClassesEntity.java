package com.example.first.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class ClassesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "class_name")
	private String class_name;

	@OneToMany(mappedBy = "classsE")
	List<StudentEnnity> students = new ArrayList<>();

	public ClassesEntity() {
	}

	public ClassesEntity(Long id, String class_name) {
		super();
		this.id = id;
		this.class_name = class_name;
	}

	public List<StudentEnnity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEnnity> students) {
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

}
