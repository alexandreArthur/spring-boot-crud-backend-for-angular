package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.models.DisciplineModel;
import com.crud.repository.DisciplineRepository;

@RestController
public class DisciplineController {
	
	private final DisciplineRepository repository;
	
	public DisciplineController(DisciplineRepository disciplineRepository) {
		this.repository = disciplineRepository;
	}

	@GetMapping("/disciplines")
	public List<DisciplineModel> getDisciplines(){
		return repository.findAll();
	}
	
	@GetMapping("/disciplines/{id}")
	public Optional<DisciplineModel> getDisciplinesById(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PostMapping("/disciplines")
	public DisciplineModel saveDiscipline(@RequestBody DisciplineModel params){
		return repository.save(params);
	}
	
	@DeleteMapping("/disciplines/{id}")
	public void deleteDiscipline(@PathVariable Long id){
		repository.deleteById(id);
	}
}
