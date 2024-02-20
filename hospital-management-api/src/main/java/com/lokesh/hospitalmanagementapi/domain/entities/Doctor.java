package com.lokesh.hospitalmanagementapi.domain.entities;

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

@Table(name="doctors")
@Entity(name="Doctor")
public class Doctor {
	
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
	public Doctor(DoctorDTO doctorDTO) {
		this.name = doctorDTO.name();
		this.email = doctorDTO.email();
		this.crm = doctorDTO.crm();
		this.telephone = doctorDTO.telephone();
		this.specialty = doctorDTO.specialty();
		this.active = true;
		this.address = new Address(doctorDTO.address());
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name cannot be blank")
	@Column(name = "name")
	private String name;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the crm
	 */
	public String getCrm() {
		return crm;
	}

	/**
	 * @param crm the crm to set
	 */
	public void setCrm(String crm) {
		this.crm = crm;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the specialty
	 */
	public Specialty getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
