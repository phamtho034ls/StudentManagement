package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.first.entity.ClassesEntity;

public interface ClassesRepository extends JpaRepository<ClassesEntity , Long>{

}
