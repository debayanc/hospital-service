package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class HospitalController {
	
	//ivate Logger logger = LoggerFactory.getLogger(HospitalController.class);
	
	
	private static final Logger log = LoggerFactory.getLogger(HospitalController.class);
	
	
	
	 @Autowired
	 private HospitalService hospitalService;


	@GetMapping("/hospitals/{id}")
	public @ResponseBody Optional<Hospital> getHospital(@PathVariable("id") int id) throws Exception {

	        return hospitalService.getHospital(id);
	    }

	@GetMapping("/hospitals/")
	public @ResponseBody List<Hospital> getAllHospitals() throws Exception {
			log.debug("in hospital controller");
			return hospitalService.getAllHospitals();
	    }


	@PostMapping("/hospitals/")
	public ResponseEntity<String> addHospital(@RequestBody Hospital hospital  ) {

		Boolean added=true;
				
		if(added)
			try {
				hospitalService.addOrUpdateHospital(hospital);
			}catch (Exception e) {
				// TODO: handle exception
				added=false;
				e.printStackTrace();;
			}
			
		return new ResponseEntity<String>("New Hospital Addded", added ? HttpStatus.OK: HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/hospitals")
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) {
		
		Boolean ok=true;
		
		if(ok)
			try {
				hospitalService.addOrUpdateHospital(hospital);
			}catch (Exception e) {
				// TODO: handle exception
				ok=false;
				e.printStackTrace();;
			}
			
		return new ResponseEntity("Hospital Updated", ok ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/hospitals")
	public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) {

		Boolean ok=true;
		if(ok)
			try {
				hospitalService.deleteHospital(hospital);
			}catch (Exception e) {
				// TODO: handle exception
				ok=false;
				e.printStackTrace();;
			}
			
		return new ResponseEntity("Hospital Deleted", ok ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
	}
	
	
}
