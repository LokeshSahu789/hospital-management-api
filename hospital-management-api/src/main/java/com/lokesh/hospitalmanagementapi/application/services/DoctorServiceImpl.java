package com.lokesh.hospitalmanagementapi.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lokesh.hospitalmanagementapi.application.usecase.doctor.FindDoctorByIdUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.doctor.FindDoctorsUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.doctor.SaveDoctorUseCase;
import com.lokesh.hospitalmanagementapi.domain.dtos.AddressDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.doctor.DoctorDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.doctor.DoctorPublicDataDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.doctor.DoctorUpdatedDataDTO;
import com.lokesh.hospitalmanagementapi.domain.entities.Address;
import com.lokesh.hospitalmanagementapi.domain.entities.Doctor;
import com.lokesh.hospitalmanagementapi.domain.services.DoctorService;

import jakarta.persistence.EntityNotFoundException;

/**
 * This class is an implementation of the DoctorService interface.
 *
 * This class provides methods to perform operations on doctors
 *
 * @author Lokesh Sahu
 * @version 1.0
 */

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private SaveDoctorUseCase saveDoctor;
	
	@Autowired
	private FindDoctorsUseCase findDoctors;
	
	@Autowired
	private FindDoctorByIdUseCase findDoctorById;
	
	@Override
	public Doctor addDoctor(DoctorDTO doctorDTO) {
		
		Doctor doctor = new Doctor(doctorDTO);
		
		return saveDoctor.execute(doctor);
	}

	@Override
	public Doctor findDoctorById(Long id) {
		Doctor doctor = findDoctorById.execute(id);
		
		if(doctor == null) throw new EntityNotFoundException("No doctor exists with this id");
		
		return doctor;
		
	}

	@Override
	public Page<DoctorPublicDataDTO> findDoctors(Pageable pageable) {
		return findDoctors.execute(pageable).map(DoctorPublicDataDTO::new);
	}

	@Override
	public Doctor updateDoctor(DoctorUpdatedDataDTO doctorUpdatedDataDTO) {
		Doctor doctor = findDoctorById.execute(doctorUpdatedDataDTO.id());
		
		if (doctor == null) {
		 throw new EntityNotFoundException("No existing doctor with this id");	
		}
			
		if (doctorUpdatedDataDTO.name() != null) {
			doctor.setName(doctorUpdatedDataDTO.name());
		}
		
		if (doctorUpdatedDataDTO.telephone() != null) {
			doctor.setName(doctorUpdatedDataDTO.telephone());
		}
		
		if (doctorUpdatedDataDTO.address() != null) {
			
			AddressDTO addressUpdatedDataDTO = doctorUpdatedDataDTO.address();
			Address address = doctor.getAddress();
			
			if (addressUpdatedDataDTO.street() != null) {
				address.setStreet(addressUpdatedDataDTO.street());
			}
			
			if (addressUpdatedDataDTO.neighborhood() != null) {
				address.setNeighbourhood(addressUpdatedDataDTO.neighborhood());
			}
			
			if (addressUpdatedDataDTO.city() != null) {
				address.setCity(addressUpdatedDataDTO.city());
			}
			
			if (addressUpdatedDataDTO.zipCode() != null) {
				address.setZipCode(addressUpdatedDataDTO.zipCode());
			}
			
			if (addressUpdatedDataDTO.state() != null) {
				address.setState(addressUpdatedDataDTO.state());
			}
			
			if (addressUpdatedDataDTO.additionalDetails() != null) {
				address.setAdditionalDetails(addressUpdatedDataDTO.additionalDetails());
			}
			
			if (addressUpdatedDataDTO.houseNumber() != null) {
				address.setHouseNumber(addressUpdatedDataDTO.houseNumber());
			}
			
			doctor.setAddress(address);
		}
		
		doctor = saveDoctor.execute(doctor);
		
		return doctor;
		
	}

	@Override
	public Doctor deactivateDoctor(Long id) {
		Doctor doctor = findDoctorById.execute(id);
		
		if(doctor == null) throw new EntityNotFoundException("No doctor exists with this id");
		
		doctor.setActive(false);
		
		return saveDoctor.execute(doctor);
		
	}

}
