package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.dto.reponse.StudentSDTO;
import com.example.first.dto.request.ClassesRequest;
import com.example.first.dto.request.StudentRequest;
import com.example.first.entity.StudentEnnity;
import com.example.first.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@GetMapping("/list")
	public List<StudentSDTO> getStudents()
	{
		return studentService.getlistStudents();
	}
	
	@GetMapping("/detail/{id}")
	public StudentSDTO getDetailStudents(@PathVariable Long id)
	{
		return studentService.getDetailStudent(id);
	}
	@PostMapping("/create")
	public StudentSDTO createStudent(@RequestBody StudentRequest bodyStudentRequest)
	{
		StudentSDTO newStd = studentService.createStudent(bodyStudentRequest);
		return newStd;
	}
	@PutMapping("/update/{id}")
	public StudentSDTO updateStd(@PathVariable Long id, @RequestBody StudentRequest bodyRequest) {
		StudentSDTO newStd = studentService.updateStudent(bodyRequest, id);
		return newStd;
	}
	@DeleteMapping("delete/{id}")
	public boolean deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
	@GetMapping("/listClass/{classId}")
	public List<StudentSDTO> getListByClass(@PathVariable Long classId){
		return studentService.getListByClass(classId);
	}
	
}
