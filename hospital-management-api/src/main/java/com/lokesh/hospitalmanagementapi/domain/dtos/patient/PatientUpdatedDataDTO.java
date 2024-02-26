package com.lokesh.hospitalmanagementapi.domain.dtos.patient;

import com.lokesh.hospitalmanagementapi.domain.dtos.AddressDTO;

import jakarta.validation.constraints.NotNull;

public record PatientUpdatedDataDTO(
		
		@NotNull(message = "id cannot be blank")
		Long id,
		String name,
		String telephone,
		AddressDTO address) {

}
