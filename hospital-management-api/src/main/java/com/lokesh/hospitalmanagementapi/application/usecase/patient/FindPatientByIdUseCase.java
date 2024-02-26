package com.lokesh.hospitalmanagementapi.application.usecase.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lokesh.hospitalmanagementapi.domain.entities.Patient;
import com.lokesh.hospitalmanagementapi.domain.repositories.PatientRepository;


/**
 * This class is used to execute the findById method 
 * 
 * @author Lokesh Sahu
 * @version 1.0
 */
@Component
public class FindPatientByIdUseCase {
	
	@Autowired
	private PatientRepository patientRepository;
	
	/**
	 * Executes the findById method from Doctor repository
	 * 
	 * @param id A long representing the doctor's unique identifier
	 * 
	 * @return The corresponding doctor if successful, or null if it is non-existent
	 *
	 */
	
	public Patient execute(Long id) {
		return patientRepository.findById(id).orElse(null);
	}
	
}
