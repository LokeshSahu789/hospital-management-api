package com.lokesh.hospitalmanagementapi.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lokesh.hospitalmanagementapi.application.usecase.consultation.FindConsultationByDoctorAndDateUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.consultation.FindConsultationByIdUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.consultation.FindConsultationByPatientAndDateUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.consultation.SaveConsultationUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.doctor.FindDoctorByIdUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.doctor.FindOneFreeDoctorBySpecialtyUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.patient.FindPatientByIdUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.patient.FindPatientsUseCase;
import com.lokesh.hospitalmanagementapi.application.usecase.patient.SavePatientUseCase;
import com.lokesh.hospitalmanagementapi.domain.dtos.AddressDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.consultation.ConsultationCanceledDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.consultation.ConsultationDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientPublicDataDTO;
import com.lokesh.hospitalmanagementapi.domain.dtos.patient.PatientUpdatedDataDTO;
import com.lokesh.hospitalmanagementapi.domain.entities.Address;
import com.lokesh.hospitalmanagementapi.domain.entities.Consultation;
import com.lokesh.hospitalmanagementapi.domain.entities.Doctor;
import com.lokesh.hospitalmanagementapi.domain.entities.Patient;
import com.lokesh.hospitalmanagementapi.domain.services.ConsultationService;
import com.lokesh.hospitalmanagementapi.domain.services.PatientService;

import jakarta.persistence.EntityNotFoundException;

/**
 * This class is an implementation of the PatientService interface.
 *
 * This class provides methods to perform operations on patients
 *
 * @author Lokesh Sahu
 * @version 1.0
 */

@Service
public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	private SaveConsultationUseCase saveConsultationUseCase;
	
	@Autowired
	private FindConsultationByIdUseCase findConsultationByIdUseCase;
	
	@Autowired
	private FindConsultationByDoctorAndDateUseCase findConsultationByDoctorAndDateUseCase;
	
	@Autowired
	private FindConsultationByPatientAndDateUseCase findConsultationByPatientAndDateUseCase;
	
	@Autowired
	private FindPatientByIdUseCase findPatientbyIdUseCase;
	
	@Autowired
	private FindDoctorByIdUseCase findDoctorByIdUseCase;
	
	@Autowired
	private FindOneFreeDoctorBySpecialtyUseCase findOneFreeDoctorBySpecialtyUseCase;	

	@Override
	public Consultation addConsultation(ConsultationDTO consultationDTO) throws Exception {
		
		Patient patient = findPatientbyIdUseCase.execute(consultationDTO.patientId());
		
		if (!patient.getActive())
			throw new Exception("This patient is not active");
		
		if(findConsultationByPatientAndDateUseCase.execute(patient.getId(), consultationDTO.consultationDate()) != null)
			throw new Exception();
		
		Doctor doctor = null;
		
		if (consultationDTO.doctorId() != null) {
			doctor = findDoctorByIdUseCase.execute(consultationDTO.doctorId());
			
			if(!doctor.getActive())
				throw new Exception("Doctor is not active");
			
			if(findConsultationByDoctorAndDateUseCase.execute(doctor.getId(), consultationDTO.consultationDate()) != null)
				throw new Exception("No doctor is free on this date");
			
		} else if (consultationDTO.specialty() != null) {
			doctor = findOneFreeDoctorBySpecialtyUseCase.execute(consultationDTO.specialty(), consultationDTO.consultationDate());
			
			if(doctor == null) throw new Exception("There is no free doctor for this date with this speciality");
			
		} else {
			throw new Exception("At least the specialty or doctor ID must be filled in");
		}
		
		Consultation consultation = new Consultation(patient, doctor, consultationDTO.consultationDate());
		
		return saveConsultationUseCase.execute(consultation);
		
	}

	@Override
	public Consultation findConsultationById(Long id) {
		Consultation consultation = findConsultationByIdUseCase.execute(id);
		
		if(consultation == null) throw new EntityNotFoundException("No existing consultation with this id");
		
		return consultation;
	}

	@Override
	public Consultation cancelConsultation(ConsultationCanceledDTO consultationCanceledDTO) {
		Consultation consultation = this.findConsultationById(consultationCanceledDTO.consultationId());
		
		consultation.setCanceled(true);
		consultation.setReasonCancellation(consultationCanceledDTO.reasonCancellation());
		
		return saveConsultationUseCase.execute(consultation);
	}

}
