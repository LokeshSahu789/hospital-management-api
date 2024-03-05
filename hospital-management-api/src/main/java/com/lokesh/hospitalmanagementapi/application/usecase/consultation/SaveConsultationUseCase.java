package com.lokesh.hospitalmanagementapi.application.usecase.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lokesh.hospitalmanagementapi.domain.entities.Consultation;
import com.lokesh.hospitalmanagementapi.domain.entities.Doctor;
import com.lokesh.hospitalmanagementapi.domain.repositories.ConsultationRepository;
import com.lokesh.hospitalmanagementapi.domain.repositories.DoctorRepository;


/**
 * This class is used to execute the save method from consultation repository 
 * 
 * @author Lokesh Sahu
 * @version 1.0
 */
@Component
public class SaveConsultationUseCase {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	
	/**
	 * Executes the save method from Consultation repository
	 * 
	 * @param consultation The Consultation to be saved in the repository
	 * @return The saved consultation if successful, or null if there is an error
	 *
	 */
	
	public Consultation execute(Consultation consultation) {
		return this.consultationRepository.save(consultation);
	}
	
}
