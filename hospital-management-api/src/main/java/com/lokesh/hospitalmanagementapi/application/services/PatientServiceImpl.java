package com.lokesh.hospitalmanagementapi.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lokesh.hospitalmanagementapi.application.usecase.patient.FindPatientByIdUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.patient.FindPatientsUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.patient.SavePatientUseCase;
import com.lokesh.hospitalmanagementapi.domain.dtos.AddressDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientPublicDataDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientUpdatedDataDTO;
import com.lokesh.hospitalmanagementapi.domain.entities.Address;
import com.lokesh.hospitalmanagementapi.domain.entities.Patient;
import com.lokesh.hospitalmanagementapi.domain.services.PatientService;

import jakarta.persistence.EntityNotFoundException;

/**
 * This class is an implementation of the PatientService interface.
 *
 * This class provides methods to perform operations on patients
 *
 * @author Lokesh Sahu
 * @version 1.0
 */

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private SavePatientUseCase savePatient;
	
	@Autowired
	private FindPatientsUseCase findPatients;
	
	@Autowired
	private FindPatientByIdUseCase findPatientById;
	
	@Override
	public Patient addPatient(PatientDTO patientDTO) {
		
		Patient patient = new Patient(patientDTO);
		
		return savePatient.execute(patient);
	}

	@Override
	public Patient findPatientById(Long id) {
		Patient patient = findPatientById.execute(id);
		
		if(patient == null) throw new EntityNotFoundException("No patient exists with this id");
		
		return patient;
		
	}

	@Override
	public Page<PatientPublicDataDTO> findPatients(Pageable pageable) {
		return findPatients.execute(pageable).map(PatientPublicDataDTO::new);
	}

	@Override
	public Patient updatePatient(PatientUpdatedDataDTO patientUpdatedDataDTO) {
		Patient patient = findPatientById.execute(patientUpdatedDataDTO.id());
		
		if (patient == null) {
		 throw new EntityNotFoundException("No existing patient with this id");	
		}
			
		if (patientUpdatedDataDTO.name() != null) {
			patient.setName(patientUpdatedDataDTO.name());
		}
		
		if (patientUpdatedDataDTO.telephone() != null) {
			patient.setTelephone(patientUpdatedDataDTO.telephone());
		}
		
		if (patientUpdatedDataDTO.address() != null) {
			
			AddressDTO addressUpdatedDataDTO = patientUpdatedDataDTO.address();
			Address address = patient.getAddress();
			
			if (addressUpdatedDataDTO.street() != null) {
				address.setStreet(addressUpdatedDataDTO.street());
			}
			
			if (addressUpdatedDataDTO.neighborhood() != null) {
				address.setNeighbourhood(addressUpdatedDataDTO.neighborhood());
			}
			
			if (addressUpdatedDataDTO.city() != null) {
				address.setCity(addressUpdatedDataDTO.city());
			}
			
			if (addressUpdatedDataDTO.zipCode() != null) {
				address.setZipCode(addressUpdatedDataDTO.zipCode());
			}
			
			if (addressUpdatedDataDTO.state() != null) {
				address.setState(addressUpdatedDataDTO.state());
			}
			
			if (addressUpdatedDataDTO.additionalDetails() != null) {
				address.setAdditionalDetails(addressUpdatedDataDTO.additionalDetails());
			}
			
			if (addressUpdatedDataDTO.houseNumber() != null) {
				address.setHouseNumber(addressUpdatedDataDTO.houseNumber());
			}
			
			patient.setAddress(address);
		}
		
		patient = savePatient.execute(patient);
		
		return patient;
		
	}

	@Override
	public Patient deactivatePatient(Long id) {
		Patient patient = findPatientById.execute(id);
		
		if(patient == null) throw new EntityNotFoundException("No patient exists with this id");
		
		patient.setActive(false);
		
		return savePatient.execute(patient);
		
	}

}
