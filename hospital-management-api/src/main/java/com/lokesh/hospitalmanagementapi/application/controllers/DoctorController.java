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

import com.lokesh.hospitalmanagementapi.domain.dtos.doctor.DoctorDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.doctor.DoctorPublicDataDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.doctor.DoctorUpdatedDataDTO;
import com.lokesh.hospitalmanagementapi.domain.entities.Doctor;
import com.lokesh.hospitalmanagementapi.domain.services.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1.0/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
	public ResponseEntity<Object> postDoctor(@RequestBody @Valid DoctorDTO doctorDTO){
		
		Doctor doctor = doctorService.addDoctor(doctorDTO);
		
		UriComponents uriComponents = UriComponentsBuilder.fromUriString("/api/v1.0/doctors/{id}").encode().build();
		
		URI uri = uriComponents.expand(doctor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(doctor);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getDoctor(@PathVariable Long id){
		Doctor doctor = doctorService.findDoctorById(id);
		
		return ResponseEntity.ok(doctor);
		
	}
	
	@GetMapping
	public ResponseEntity<Object> getDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
		Page<DoctorPublicDataDTO> doctors = doctorService.findDoctors(pageable);
		
		return ResponseEntity.ok(doctors);
		
	}
	
	@PutMapping
	public ResponseEntity<Object> putDoctor(@RequestBody @Valid DoctorUpdatedDataDTO doctorUpdatedDataDTO){
		Doctor doctor = doctorService.updateDoctor(doctorUpdatedDataDTO);
		
		return ResponseEntity.ok(doctor);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDoctor(@PathVariable Long id){
		Doctor doctor = doctorService.deactivateDoctor(id);
		
		return ResponseEntity.ok(doctor);
		
	}
	
}
