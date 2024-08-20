package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.dto.reponse.ClassesDTO;
import com.example.first.dto.request.ClassesRequest;
import com.example.first.entity.ClassesEntity;
import com.example.first.repository.ClassesRepository;
import com.example.first.service.ClassesService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/class")
public class ClassesController {
	@Autowired
	ClassesService classesService;
	@GetMapping("/list")
	public List<ClassesDTO> getSlasses()
	{
		return classesService.getListClass();
	}
	@GetMapping("/detail/{id}")
	public ClassesDTO getDetailClass(@PathVariable Long id)
	{
		return classesService.getDetailClass(id);
	}
	@DeleteMapping("/delete/{id}")
	public boolean deleteClasses(@PathVariable Long id )
	{
		return classesService.deleteClasses(id);
	}
	@PutMapping("/update/{id}")
	public ClassesDTO updateClasses(@PathVariable Long id, @RequestBody ClassesRequest bodyClassesRequest) {
		//TODO: process PUT request
		ClassesEntity newClass = new ClassesEntity();
		newClass.setId(id);
		newClass.setClass_name(bodyClassesRequest.getClass_name());
		return classesService.saveClass(newClass);
	}
}
