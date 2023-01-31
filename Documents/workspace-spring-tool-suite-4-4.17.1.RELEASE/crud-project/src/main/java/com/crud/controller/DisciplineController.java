package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.models.DisciplineModel;
import com.crud.repository.DisciplineRepository;

@RestController
public class DisciplineController {
	
	private final DisciplineRepository repository;
	
	public DisciplineController(DisciplineRepository disciplineRepository) {
		this.repository = disciplineRepository;
	}

	@GetMapping("/api/disciplines")
	public List<DisciplineModel> getDisciplines(){
		return repository.findAll();
	}
	
	@GetMapping("/api/disciplines/{id}")
	public ResponseEntity<DisciplineModel> getDisciplinesById(@PathVariable Long id){
		return repository.findById(id)
				.map(res -> ResponseEntity.ok().body(res))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/api/disciplines")
	//@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<DisciplineModel>  saveDiscipline(@RequestBody DisciplineModel params){
		return ResponseEntity.status(HttpStatus.CREATED).body( repository.save(params));
	}
	
	@DeleteMapping("/api/disciplines/{id}")
	public void deleteDiscipline(@PathVariable Long id){
		repository.deleteById(id);
	}
}
