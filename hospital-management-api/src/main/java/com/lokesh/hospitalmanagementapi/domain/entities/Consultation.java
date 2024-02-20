package com.lokesh.hospitalmanagementapi.domain.entities;

import java.time.LocalDateTime;

import com.lokesh.hospitalmanagementapi.domain.dtos.doctor.DoctorDTO;
import com.lokesh.hospitalmanagementapi.domain.enums.Specialty;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name="consultations")
@Entity(name="Consultation")
public class Consultation {
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param crm
	 * @param telephone
	 * @param specialty
	 * @param active
	 * @param address
	 */
	public Consultation(DoctorDTO doctorDTO) {
		this.email = doctorDTO.email();
		this.crm = doctorDTO.crm();
		this.telephone = doctorDTO.telephone();
		this.specialty = doctorDTO.specialty();
		this.active = true;
		this.address = new Address(doctorDTO.address());
	}
	
	public Consultation() {
		
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "ConsultationDate cannot be null")
	@Column(name = "consultation_date")
	private LocalDateTime consultationDate;
	
	@NotBlank(message = "email cannot be blank")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "crm cannot be blank")
	@Column(name = "crm", length = 6)
	private String crm;
	
	@NotBlank(message = "telephone cannot be blank")
	@Column(name = "telephone")
	private String telephone;
	
	@NotNull(message = "specialty cannot be null")
	@Enumerated(EnumType.STRING)
	private Specialty specialty;
	
	@NotNull(message = "active cannot be blank")
	@Column(name = "active")
	private Boolean active;
	
	@NotNull(message = "address cannot be blank")
	@Embedded
	private Address address;
	
	
	
}
