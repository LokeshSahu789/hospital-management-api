package com.lokesh.hospitalmanagementapi.domain.entities;

import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Table(name="patients")
@Entity(name="Patient")
public class Patient {
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param cpf
	 * @param telephone
	 * @param active
	 * @param address
	 */
	public Patient(PatientDTO patientDTO) {
		this.name = patientDTO.name();
		this.email = patientDTO.email();
		this.cpf = patientDTO.cpf();
		this.telephone = patientDTO.telephone();
		this.active = true;
		this.address = new Address(patientDTO.address());
	}

	public Patient() {}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name cannot be blank")
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = "email cannot be blank")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "cpf cannot be blank")
	@Pattern(regexp = "\\d{11}", message = "invalid format for cpf")
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	@NotBlank(message = "telephone cannot be blank")
	@Column(name = "telephone")
	private String telephone;
	
	@NotNull(message = "active cannot be blank")
	@Column(name = "_active")
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
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
