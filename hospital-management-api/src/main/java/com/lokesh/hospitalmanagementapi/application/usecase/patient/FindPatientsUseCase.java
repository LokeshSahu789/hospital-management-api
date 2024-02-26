package com.lokesh.hospitalmanagementapi.application.usecase.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.lokesh.hospitalmanagementapi.domain.entities.Doctor;
import com.lokesh.hospitalmanagementapi.domain.entities.Patient;
import com.lokesh.hospitalmanagementapi.domain.repositories.DoctorRepository;
import com.lokesh.hospitalmanagementapi.domain.repositories.PatientRepository;


/**
 * This class is used to execute the findDoctorsByActiveTrue method from doctor repository
 * 
 * @author Lokesh Sahu
 * @version 1.0
 */


@Component
public class FindPatientsUseCase {
	
	@Autowired
	private PatientRepository patientRepository;
	
	/**
	 * Executes the findDoctorsByActiveTrue method from Doctor repository
	 * 
	 * @param pageable Pagination information, such as size and page number
	 * 
	 * @return A paginated list with active stored doctors if successful, or null if there is an error
	 *
	 */
	
	public Page<Patient> execute(Pageable pageable) {
		return this.patientRepository.findPatientsByActiveTrue(pageable);
	}
	
}
