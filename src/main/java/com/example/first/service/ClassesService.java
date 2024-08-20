package com.example.first.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.first.dto.reponse.ClassesDTO;
import com.example.first.entity.ClassesEntity;
import com.example.first.repository.ClassesRepository;

@Service
public class ClassesService {
	private final ClassesRepository classesRepository;

	public ClassesService(ClassesRepository classesRepository) {
	
		this.classesRepository = classesRepository;
	}

	public List<ClassesDTO> getListClass() {
		List<ClassesEntity> reuslt = classesRepository.findAll();
		
		List<ClassesDTO> listClass = new ArrayList<ClassesDTO>();
		
		for (ClassesEntity classesEntity : reuslt) {
			ClassesDTO dto = new ClassesDTO(classesEntity.getId(), classesEntity.getClass_name());
			listClass.add(dto);
		}
		return listClass;
	}
	public ClassesDTO getDetailClass(Long id)
	{
		Optional<ClassesEntity> reuslt = classesRepository.findById(id);
		
		if(reuslt.isEmpty()) {
			return null;
		}
		
		ClassesEntity rs = reuslt.get();
		
		ClassesDTO dto = new ClassesDTO(rs.getId(),rs.getClass_name());
		return  dto;
		
	}
	public ClassesDTO saveClass(ClassesEntity newClass)
	{
		ClassesEntity classEn = classesRepository.save(newClass);
		ClassesDTO dto = new ClassesDTO();
		dto.setId(classEn.getId());
		dto.setClass_name(classEn.getClass_name());
		return dto;
	}
	public boolean deleteClasses(Long id)
	{
		boolean isExist = classesRepository.existsById(id);
		if (isExist)
		{
			classesRepository.deleteById(id);
			return true;
		}
		else 
		{
			return false;
		}
	}
}
