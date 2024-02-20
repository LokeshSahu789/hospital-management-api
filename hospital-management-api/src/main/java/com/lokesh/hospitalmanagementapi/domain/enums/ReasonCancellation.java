package com.lokesh.hospitalmanagementapi.domain.enums;

public enum ReasonCancellation {
	
	/**
	 * Patient gave up to attend the consultation date
	 */
	PATIENT_GAVE_UP,
	
	/**
	 * Doctor canceled the consultation date and will reschedule
	 */
	DOCTOR_CANCELLED,
	
	/**
	 * Any other reason
	 */
	OTHER;
	
}
