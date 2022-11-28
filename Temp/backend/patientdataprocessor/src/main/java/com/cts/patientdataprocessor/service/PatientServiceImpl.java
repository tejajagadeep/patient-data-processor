package com.cts.patientdataprocessor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessor.exception.IdAlredyExistsException;
import com.cts.patientdataprocessor.model.Patient;
import com.cts.patientdataprocessor.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	
	
	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}


	@Override
	public Patient getByContactNumber(Long contactNumber) {
		return patientRepository.findByContactNumber(contactNumber);
	}


	@Override
	public Patient registerPatient(Patient patient) {
		
		Patient patientDummy = patientRepository.findByContactNumber(patient.getContactNumber());
		if(patientDummy!=null) {
			throw new  IdAlredyExistsException("Contact Number Already Present");
		}
		return patientRepository.save(patient);
	}

}
