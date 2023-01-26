package com.crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crud.models.DisciplineModel;
import com.crud.repository.DisciplineRepository;

@SpringBootApplication
public class CrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDataBase(DisciplineRepository disciplineRepository) {
		return args -> {
			disciplineRepository.deleteAll();
			
			DisciplineModel d = new DisciplineModel();
			d.setName("math");
			d.setCategory("math");
			
			disciplineRepository.save(d);
		};
	}

}
