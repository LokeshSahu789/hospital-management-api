package com.lokesh.hospitalmanagementapi.application.usecase.consultation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lokesh.hospitalmanagementapi.domain.entities.Consultation;
import com.lokesh.hospitalmanagementapi.domain.entities.Doctor;
import com.lokesh.hospitalmanagementapi.domain.enums.Specialty;
import com.lokesh.hospitalmanagementapi.domain.repositories.ConsultationRepository;
import com.lokesh.hospitalmanagementapi.domain.repositories.DoctorRepository;


/**
 * This class is used to execute the findConsultationByPatientAndDate method from consultation repository 
 * 
 * @author Lokesh Sahu
 * @version 1.0
 */
@Component
public class FindConsultationByPatientAndDateUseCase {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	/**
	 * Executes the findConsultationByPatientAndDate method from Consultation repository
	 * 
	 * @param patientId The patient's id from the consultation
	 * @param consultationDate The date of the consultation
	 * @return The corresponding consultation if successful, or null if it is non-existent
	 *
	 */
	
	public Consultation execute(Long patientId, LocalDateTime consultationDate) {
		return this.consultationRepository.findConsultationByPatientAndDate(patientId, consultationDate);
	}
	
}
