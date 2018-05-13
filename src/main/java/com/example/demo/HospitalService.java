package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

	@Autowired
	HospitalRepository hospitalRepository;

	@PostConstruct	
	public void initHospital() {
		List<Hospital> hospitalList = new ArrayList<>(Arrays.asList(

				new Hospital(101, "Apollo Hospital", "Chennai", 3.8),

				new Hospital(102, "Global Hospital", "Chennai", 3.5),

				new Hospital(103, "VCare Hospital", "Bangalore", 3)));

		hospitalRepository.saveAll(hospitalList);

	}

	public List<Hospital> getAllHospitals() {
		return (List<Hospital>) hospitalRepository.findAll();
	}

	public Optional<Hospital> getHospital(int id) {
		return hospitalRepository.findById(id);
	}

	public void addOrUpdateHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public void deleteHospital(Hospital hospital) {

		hospitalRepository.delete(hospital);

	}

}
