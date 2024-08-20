package com.example.first.dto.request;


public class StudentRequest {
	private  Long id;
	private String full_name;
	private String phone;
	private String birth;
	private double math;
	private double english;
	private Long class_id;
	public StudentRequest() {
		
	}
	public StudentRequest(Long id, String full_name, String phone, String birth, double math, double english,
			Long class_id) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.phone = phone;
		this.birth = birth;
		this.math = math;
		this.english = english;
		this.class_id = class_id;
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
	public Long getClass_id() {
		return class_id;
	}
	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}
	
}
