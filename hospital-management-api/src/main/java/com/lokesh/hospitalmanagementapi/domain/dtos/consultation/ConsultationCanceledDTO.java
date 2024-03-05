package com.lokesh.hospitalmanagementapi.domain.dtos.consultation;

import com.lokesh.hospitalmanagementapi.domain.enums.ReasonCancellation;
import jakarta.validation.constraints.NotNull;

/**
* Data transfer object used to transfer data that will be saved in a Address entity
* 
* @author Lokesh Sahu
* @version 1.0
*/

public record ConsultationCanceledDTO(
		@NotNull
		Long consultationId,
		
		@NotNull
		ReasonCancellation reasonCancellation) {
	
}
