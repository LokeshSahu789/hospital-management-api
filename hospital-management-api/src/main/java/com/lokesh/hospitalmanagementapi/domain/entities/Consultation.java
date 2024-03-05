package com.lokesh.hospitalmanagementapi.domain.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lokesh.hospitalmanagementapi.domain.enums.ReasonCancellation;
import com.lokesh.hospitalmanagementapi.domain.enums.Specialty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name="consultations")
@Entity(name="Consultation")
public class Consultation {
	
	public Consultation() {
		
	}

	/**
	 * @param consultationDate
	 * @param patient
	 * @param doctor
	 */
	public Consultation(Patient patient, Doctor doctor, LocalDateTime consultationDate) {
		this.consultationDate = consultationDate;
		this.patient = patient;
		this.doctor = doctor;
		this.canceled = false;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "ConsultationDate cannot be null")
	@Column(name = "consultation_date")
	private LocalDateTime consultationDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@Column(name = "canceled")
	private Boolean canceled;
	
	@Column(name = "reason_cancellation")
	@Enumerated(EnumType.STRING)
	private ReasonCancellation reasonCancellation;;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the consultationDate
	 */
	public LocalDateTime getConsultationDate() {
		return consultationDate;
	}

	/**
	 * @param consultationDate the consultationDate to set
	 */
	public void setConsultationDate(LocalDateTime consultationDate) {
		this.consultationDate = consultationDate;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the cancelled
	 */
	public Boolean getCanceled() {
		return canceled;
	}

	/**
	 * @param cancelled the cancelled to set
	 */
	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	/**
	  * Returns the reason of consultation cancellation
	 * @return An enum class representing the reason of cancellation.
	 * @see ReasonCancellation
	 */
	public ReasonCancellation getReasonCancellation() {
		return reasonCancellation;
	}

	/**
	 * Sets the reason of consultation cancellation
	 * @param reasonCancellation 
	 */
	public void setReasonCancellation(ReasonCancellation reasonCancellation) {
		this.reasonCancellation = reasonCancellation;
	}
		
	
}
