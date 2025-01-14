package com.example.first.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.first.entity.StudentEnnity;

public interface StudentRepository extends JpaRepository<StudentEnnity, Long>{
	
	@Query(value= "select * from students where class_id=?1", nativeQuery = true)
	public List<StudentEnnity> findByClass_Id(Long classId);
}
