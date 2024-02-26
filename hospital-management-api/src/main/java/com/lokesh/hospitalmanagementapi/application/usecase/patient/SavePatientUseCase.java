package com.lokesh.hospitalmanagementapi.application.usecase.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lokesh.hospitalmanagementapi.domain.entities.Patient;
import com.lokesh.hospitalmanagementapi.domain.repositories.PatientRepository;


/**
 * This class is used to execute the save method from doctor repository 
 * 
 * @author Lokesh Sahu
 * @version 1.0
 */
@Component
public class SavePatientUseCase {
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	/**
	 * Executes the save method from Doctor repository
	 * 
	 * @param doctor The Doctor to be saved in the repository
	 * @return The saved doctor if successful, or null if there is an error
	 *
	 */
	
	public Patient execute(Patient patient) {
		return this.patientRepository.save(patient);
	}
	
}
