package com.crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column
	String name;
	@Column
	String category;
}
