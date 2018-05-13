package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
		
	public List<Hospital> getAllHospitals(){
		return (List<Hospital>) hospitalRepository.findAll();
	}
	
	public Optional<Hospital> getHospital(int id){
		return hospitalRepository.findById(id);
	}
	
	public void addOrUpdateHospital(Hospital hospital){
		hospitalRepository.save(hospital);
	}
	
	public void deleteHospital(Hospital hospital) {
		
		hospitalRepository.delete(hospital);

	}
	
	
}
