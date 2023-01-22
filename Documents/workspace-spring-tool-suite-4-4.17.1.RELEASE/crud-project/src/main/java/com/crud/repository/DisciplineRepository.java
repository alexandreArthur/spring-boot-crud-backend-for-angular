package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.models.DisciplineModel;

public interface DisciplineRepository extends JpaRepository<DisciplineModel, Long>{

}

