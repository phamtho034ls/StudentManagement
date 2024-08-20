package com.example.first.dto.request;

public class ClassesRequest {
	private Long id;
	private String class_name;
	public ClassesRequest() {
		
	}
	public ClassesRequest(Long id, String class_name) {
		super();
		this.id = id;
		this.class_name = class_name;
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
