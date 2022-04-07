package com.wings.wingsofferservice.controller;

import com.wings.wingsofferservice.DTO.DemandDTO;
import com.wings.wingsofferservice.DTO.DemandFilterDTO;
import com.wings.wingsofferservice.Models.Demand;
import com.wings.wingsofferservice.Models.EtatDemand;
import com.wings.wingsofferservice.Service.DemandeServcie;
import com.wings.wingsofferservice.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DemandController {

	@Autowired
	DemandRepository demandRepository;



	@Autowired
	DemandeServcie demandeServcie;


	@GetMapping("/GetAllDemand")
	public List<Demand> getAllDemand() {
			return  demandeServcie.getAllDemand();
	}



	@GetMapping("/GetDemandById/{id}")
	public Optional<Demand> getDemandById(@PathVariable("id") long id) {
		return demandeServcie.getDemandById(id);
	}

	/*@GetMapping("/GetDemandByFilter")
	public Optional<Demand> getDemandByFilter(@RequestBody DemandFilterDTO filterDTO) {
		return demandeServcie.getDemandByFilter(filterDTO);
	}*/

	//"multipart/form-data",
	@RequestMapping(value = "/AddDemand", method = RequestMethod.POST,
			consumes = {"multipart/form-data","application/json"})
	public ResponseEntity<?> AddDemand (@RequestBody DemandDTO demand){
		try{

			demandeServcie.AddDemand(demand);
			return new ResponseEntity<>("Demand registered successfully", HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/UpdateRouteById/{id}")
	public Optional<Demand> updateDemand(@PathVariable("id") long id, @RequestBody DemandDTO demandDTO) {
		try{
			return demandeServcie.UpdateDemand(id,demandDTO);
		}catch (Exception e) {
			return null;
		}
	}


	@DeleteMapping("/DeleteDemandById/{id}")
	public ResponseEntity<HttpStatus> deleteDemand(@PathVariable("id") long id) {
		try {
				demandeServcie.DeleteDemandById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/DeleteAllDemand")
	public ResponseEntity<HttpStatus> deleteAllDemand() {
		try {
			demandeServcie.DeleteAllDemand();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
