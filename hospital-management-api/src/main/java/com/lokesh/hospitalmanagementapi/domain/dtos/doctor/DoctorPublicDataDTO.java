package com.lokesh.hospitalmanagementapi.domain.dtos.doctor;

import com.lokesh.hospitalmanagementapi.domain.entities.Doctor;
import com.lokesh.hospitalmanagementapi.domain.enums.Specialty;

public record DoctorPublicDataDTO(String name, String email, String crm, Specialty specialty) {
	
	public DoctorPublicDataDTO(Doctor doctor) {
		this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
	}

}
