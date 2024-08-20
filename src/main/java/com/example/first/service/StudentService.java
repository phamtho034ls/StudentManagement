package com.example.first.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first.dto.reponse.ClassesDTO;
import com.example.first.dto.reponse.StudentSDTO;
import com.example.first.dto.request.ClassesRequest;
import com.example.first.dto.request.StudentRequest;
import com.example.first.entity.ClassesEntity;
import com.example.first.entity.StudentEnnity;
import com.example.first.repository.ClassesRepository;
import com.example.first.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	private final ClassesRepository classesRepository;
	public StudentService(StudentRepository studentRepository,ClassesRepository classesRepository) {
		
		this.studentRepository = studentRepository;
		this.classesRepository = classesRepository;
	}
	public List<StudentSDTO> getlistStudents() {
		List<StudentEnnity> reuslt = studentRepository.findAll();
		
		List<StudentSDTO> listClass = new ArrayList<StudentSDTO>();
		
		for (StudentEnnity studentEntity : reuslt) {
			StudentSDTO dto = new StudentSDTO();
			dto.setId(studentEntity.getId());
			dto.setBirth(studentEntity.getBirth());
			dto.setEnglish(studentEntity.getEnglish());
			dto.setFull_name(studentEntity.getFull_name());;
			dto.setMath(studentEntity.getMath());
			dto.setPhone(studentEntity.getPhone());
			dto.setClass_id( new ClassesDTO(studentEntity.getClasssE().getId(), studentEntity.getClasssE().getClass_name()));
			listClass.add(dto);
		}
		return listClass;
	}
	public StudentSDTO getDetailStudent(Long id)
	{
		StudentEnnity studentEntity = studentRepository.findById(id).get();
		StudentSDTO dto = new StudentSDTO();
		dto.setId(studentEntity.getId());
		dto.setBirth(studentEntity.getBirth());
		dto.setEnglish(studentEntity.getEnglish());
		dto.setFull_name(studentEntity.getFull_name());;
		dto.setMath(studentEntity.getMath());
		dto.setPhone(studentEntity.getPhone());
		dto.setClass_id( new ClassesDTO(studentEntity.getClasssE().getId(), studentEntity.getClasssE().getClass_name()));
		
		return dto;
	}
	public StudentSDTO createStudent(StudentRequest newStudent)
	{
		ClassesEntity existStudentEn = classesRepository.findById(newStudent.getClass_id()).get();
		if (existStudentEn==null)
		{
			return null;
		}
		StudentEnnity newStdEn = new StudentEnnity();
		newStdEn.setClasssE(existStudentEn);
		newStdEn.setBirth(newStudent.getBirth());
		newStdEn.setEnglish(newStudent.getEnglish());
		newStdEn.setFull_name(newStudent.getFull_name());
		newStdEn.setMath(newStudent.getMath());
		newStdEn.setPhone(newStudent.getPhone());
		
		StudentEnnity createStd = studentRepository.save(newStdEn);
		StudentSDTO newDto = new StudentSDTO();
		newDto.setId(createStd.getId());
		newDto.setBirth(createStd.getBirth());
		newDto.setEnglish(createStd.getEnglish());
		newDto.setFull_name(createStd.getFull_name());
		newDto.setMath(createStd.getMath());
		newDto.setPhone(createStd.getPhone());
		newDto.setClass_id(new ClassesDTO( createStd.getClasssE().getId(),createStd.getClasssE().getClass_name()));
		return newDto;
	}
	public StudentSDTO updateStudent(StudentRequest newStudent , Long id)
	{
		ClassesEntity existStudentEn = classesRepository.findById(newStudent.getClass_id()).get();
		if (existStudentEn==null)
		{
			return null;
		}
		StudentEnnity newStdEn = new StudentEnnity();
		newStdEn.setClasssE(existStudentEn);
		newStdEn.setId(newStudent.getId());
		newStdEn.setBirth(newStudent.getBirth());
		newStdEn.setEnglish(newStudent.getEnglish());
		newStdEn.setFull_name(newStudent.getFull_name());
		newStdEn.setMath(newStudent.getMath());
		newStdEn.setPhone(newStudent.getPhone());
		
		StudentEnnity createStd = studentRepository.save(newStdEn);
		StudentSDTO newDto = new StudentSDTO();
		newDto.setId(id);
		newDto.setBirth(createStd.getBirth());
		newDto.setEnglish(createStd.getEnglish());
		newDto.setFull_name(createStd.getFull_name());
		newDto.setMath(createStd.getMath());
		newDto.setPhone(createStd.getPhone());
		newDto.setClass_id(new ClassesDTO( createStd.getClasssE().getId(),createStd.getClasssE().getClass_name()));
		return newDto;
	}
	public boolean deleteStudent(Long id) {
		boolean isExist = studentRepository.existsById(id);
		if(isExist) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}
	public List<StudentSDTO> getListByClass(Long classId){
		List<StudentEnnity> result = studentRepository.findByClass_Id(classId);
		List<StudentSDTO> listStudents = new ArrayList<>();
		for (StudentEnnity studentEntity : result) {
			StudentSDTO dto = new StudentSDTO();
			
			dto.setId(studentEntity.getId());
			dto.setBirth(studentEntity.getBirth());
			dto.setEnglish(studentEntity.getEnglish());
			dto.setFull_name(studentEntity.getFull_name());;
			dto.setMath(studentEntity.getMath());
			dto.setPhone(studentEntity.getPhone());
			dto.setClass_id( new ClassesDTO(studentEntity.getClasssE().getId(), studentEntity.getClasssE().getClass_name()));
			
			listStudents.add(dto);
		}
		return listStudents;
	
	}
}
