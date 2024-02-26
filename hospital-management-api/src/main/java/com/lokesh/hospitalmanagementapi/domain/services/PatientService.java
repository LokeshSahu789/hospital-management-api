package com.lokesh.hospitalmanagementapi.domain.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientPublicDataDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientUpdatedDataDTO;
import com.lokesh.hospitalmanagementapi.domain.entities.Patient;


/**
 * Patient service interface for managing patient information.
*
 * @see Patient
 * @author Lokesh Sahu
 * @version 1.0
*/
public interface PatientService {

	/**
	 * Adds a new doctor to the repository
	 * 
	 * @param doctorDTO A data transfer object representing a doctor to add
	 * @return The saved doctor if successfull, or null if there is an error
	 */
	public Patient addPatient(PatientDTO patientDTO);
	
	/**
   	* Finds a stored doctor by id.
   	* 
   	* @param id A long representing the doctor's unique identifier
   	* @return The corresponding doctor if successful, or null if it is non-existent.
   	*/
	public Patient findPatientById(Long id);
	
	/**
	 * Retrieves a paginated sublist of doctors.
	 * 
	 * @param pageable Pagination information, such as size and page number
	 *  
	 * @return A paginated sublist containing data transfer objects with doctors public information in the repository
	 */
	public Page<PatientPublicDataDTO> findPatients(Pageable pageable);
	
	/**
     * Updates an existing doctor record
     * @param doctorUpdatedDataDTO Data transfer object containing the doctor updated data along with their corresponding id 
	 *  
	 * @return The updated doctor if successful,  or null if there is an error.
	 */
	public Patient updatePatient(PatientUpdatedDataDTO patientUpdatedDataDTO);
	
	/**
     * Deactivates an existing doctor record by provided id
     * @param id Long that represents the doctor's unique identifier
	 *  
	 * @return The deactivated doctor if successful,  or null if there is an error.
	 */
	public Patient deactivatePatient(Long id);
	
}
