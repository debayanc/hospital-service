package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, Integer>{
	
	public Optional<Hospital> findById(int Id);
	
	public List<Hospital> findAll();
		
	public void delete(Hospital hospital);
	
	
}
