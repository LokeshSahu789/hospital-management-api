package com.lokesh.hospitalmanagementapi.domain.entities;

import com.lokesh.hospitalmanagementapi.domain.dtos.AddressDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class Address {

	public Address() {
		
	}
	
	/**
	* Constructor for class Address
	* @param addressDTO  Data transfer object containing Address information
	* @see AddressDTO
	*/
	
	public Address(AddressDTO addressDTO) {
		this.street = addressDTO.street();
		this.neighbourhood = addressDTO.neighborhood();
		this.zipCode = addressDTO.zipCode();
		this.city = addressDTO.city();
		this.state = addressDTO.state();
		this.additionalDetails = addressDTO.additionalDetails();
		this.houseNumber = addressDTO.houseNumber();
	}

	@NotBlank(message = "Street cannot be blank")
	@Column(name = "street")
	private String street;
	
	@NotBlank(message = "neighbourhood cannot be blank")
	@Column(name = "neighbourhood")
	private String neighbourhood;
	
	@NotBlank(message = "zipcode cannot be blank")
	@Pattern(regexp="\\d{8}", message="invalid format for zipCode")
	@Column(name = "zip_code")
	private String zipCode;
	
	@NotBlank(message = "City cannot be blank")
	@Column(name = "city")
	private String city;
	
	@NotBlank(message = "state cannot be blank")
	@Column(name = "state")
	private String state;
	
	@Column(name = "additional_details")
	private String additionalDetails;
	
	@Column(name = "house_number")
	private String houseNumber;

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the neighbourhood
	 */
	public String getNeighbourhood() {
		return neighbourhood;
	}

	/**
	 * @param neighbourhood the neighbourhood to set
	 */
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the additionalDetails
	 */
	public String getAdditionalDetails() {
		return additionalDetails;
	}

	/**
	 * @param additionalDetails the additionalDetails to set
	 */
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	/**
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	
	
}
