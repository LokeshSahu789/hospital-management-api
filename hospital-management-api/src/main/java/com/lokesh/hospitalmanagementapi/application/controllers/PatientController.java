package com.lokesh.hospitalmanagementapi.application.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientPublicDataDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientUpdatedDataDTO;
import com.lokesh.hospitalmanagementapi.domain.entities.Patient;
import com.lokesh.hospitalmanagementapi.domain.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/")
	public ResponseEntity<Object> postPatient(@RequestBody @Valid PatientDTO patientDTO){
		
		Patient patient = patientService.addPatient(patientDTO);
		
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("/api/v1.0/patients/{id}").encode().build();
		
		URI uri = uriComponents.expand(patient.getId()).toUri();
		
		return ResponseEntity.created(uri).body(patient);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getPatient(@PathVariable Long id){
		Patient patient = patientService.findPatientById(id);
		
		return ResponseEntity.ok(patient);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getPatients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
		Page<PatientPublicDataDTO> doctors = patientService.findPatients(pageable);
		
		return ResponseEntity.ok(doctors);
		
	}
	
	@PutMapping("/")
	public ResponseEntity<Object> putPatient(@RequestBody @Valid PatientUpdatedDataDTO patientUpdatedDataDTO){
		Patient patient = patientService.updatePatient(patientUpdatedDataDTO);
		
		return ResponseEntity.ok(patient);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePatient(@PathVariable Long id){
		Patient patient = patientService.deactivatePatient(id);
		
		return ResponseEntity.ok(patient);
		
	}
	
}
