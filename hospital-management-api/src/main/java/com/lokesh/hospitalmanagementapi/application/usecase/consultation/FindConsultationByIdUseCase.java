package com.lokesh.hospitalmanagementapi.application.usecase.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lokesh.hospitalmanagementapi.domain.entities.Consultation;
import com.lokesh.hospitalmanagementapi.domain.repositories.ConsultationRepository;


/**
 * This class is used to execute the findById method 
 * 
 * @author Lokesh Sahu
 * @version 1.0
 */
@Component
public class FindConsultationByIdUseCase {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	/**
	 * Executes the findById method from Consultation repository
	 * 
	 * @param id A long representing the consultation unique identifier
	 * 
	 * @return The corresponding consultation if successful, or null if it is non-existent
	 *
	 */
	
	public Consultation execute(Long id) {
		return consultationRepository.findById(id).orElse(null);
	}
	
}
