package com.lokesh.hospitalmanagementapi.domain.dtos.consultation;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lokesh.hospitalmanagementapi.domain.enums.Specialty;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

/**
* Data transfer object used to transfer data that will be saved in a Address entity
* 
* @author Lokesh Sahu
* @version 1.0
*/

public record ConsultationDTO(
		
		Long doctorId,
		
		@NotNull(message = "Patient Id cannot be null")
		Long patientId,
		
		@NotNull(message = "consultation date cannot be null")
		@Future
		@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
		LocalDateTime consultationDate,
		
		Specialty specialty) {}
