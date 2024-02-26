package com.lokesh.hospitalmanagementapi.domain.dtos.patient;

import com.lokesh.hospitalmanagementapi.domain.entities.Patient;

public record PatientPublicDataDTO(String name, String email, String cpf) {
	
	public PatientPublicDataDTO(Patient patient) {
		this(patient.getName(), patient.getEmail(), patient.getCpf());
	}

}
