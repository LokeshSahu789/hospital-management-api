package com.lokesh.hospitalmanagementapi.domain.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lokesh.hospitalmanagementapi.domain.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
	
	/**
	 * 
	 * @param patientId The patient's id from the consultation
	 * @param consultationDate The date of the consultation
	 * @return The corresponding consultation if successful, or null if it is non-existent
	 */
	@Query("""
			select c from Consultation c
			where c.patient.id = :patientId
			and c.consultationDate = :consultationDate 
			and c.canceled = false
			""")
	Consultation findConsultationByPatientAndDate(Long patientId, LocalDateTime consultationDate);

	/**
	 * 
	 * @param doctorId The doctor's id from the consultation
	 * @param consultationDate The date of the consultation
	 * @return The corresponding consultation if successful, or null if it is non-existent
	 */
	@Query("""
			select c from Consultation c
			where c.doctor.id = :doctorId
			and c.consultationDate = :consultationDate 
			and c.canceled = false
			""")
	Consultation findConsultationByDoctorAndDate(Long doctorId, LocalDateTime consultationDate);
	
}
