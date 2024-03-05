package com.lokesh.hospitalmanagementapi.domain.services;

import com.lokesh.hospitalmanagementapi.domain.dtos.consultation.ConsultationCanceledDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.consultation.ConsultationDTO;
import com.lokesh.hospitalmanagementapi.domain.entities.Consultation;
import com.lokesh.hospitalmanagementapi.domain.entities.Patient;


/**
 * Patient service interface for managing patient information.
*
 * @see Patient
 * @author Lokesh Sahu
 * @version 1.0
*/
public interface ConsultationService {

	/**
	* Adds a new consultation to the repository.
	* 
	* @param consultationDTO A data transfer object representing a consultation to add.
	* @return The saved consultation if successful,  or throws an exception if there is an error.
	 * @throws Exception 
	 * @throws ConsultationValidationException if there is a validation error
	*/
	public Consultation addConsultation(ConsultationDTO consultationDTO) throws Exception;
	
	/**
   	* Finds a stored consultation by id.
   	* 
   	* @param id A long representing the consultation's unique identifier
   	* @return The corresponding consultation if successful, or null if it is non-existent.
   	*/
	public Consultation findConsultationById(Long id);
	
	/**
	 * Cancels and updates an existing query in the repository
	 * @param consultationCanceledDTO A data transfer object representing the consultation that will be canceled.
	* @return The canceled consultation if successful,  or throws an exception if there is an error.
	 */
	public Consultation cancelConsultation(ConsultationCanceledDTO consultationCanceledDTO);
	
}
