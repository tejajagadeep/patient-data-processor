package com.cts.patientdataprocessor.servcie;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessor.exception.IdAlredyExistsException;
import com.cts.patientdataprocessor.model.Patient;
//import com.cts.patientdataprocessor.model.Report;
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
			throw new  IdAlredyExistsException("Contact Number Already Exists.");
		}
		if(patientRepository.findByEmail(patient.getEmail())!=null) {
			throw new  IdAlredyExistsException("Email Id Already Exists.");
		}
		return patientRepository.save(patient);
	}


	@Override
	public Patient updatePatientDetails(Long contactNumber, Patient patient) {
		Patient patientDummy = patientRepository.findByContactNumber(contactNumber);
		if(patientDummy==null) {
			throw new  NoSuchElementException("Patient doesn't exist");
		}
		return patientRepository.save(patient);
	}


	@Override
	public List<Patient> deletePatient(Long contactNumber) {
		Patient patientDummy = patientRepository.findByContactNumber(contactNumber);
		if(patientDummy==null) {
			throw new  NoSuchElementException("Patient doesn't exist");
		}
		patientRepository.deleteById(contactNumber);
		return patientRepository.findAll();
	}


//	@Override
//	public Set<Report> getBypatientReports(Long contactNumber) {
//		Patient patientDummy = patientRepository.findByContactNumber(contactNumber);
//		if(patientDummy==null) {
//			throw new  NoSuchElementException("Patient doesn't exist");
//		}
//		return patientDummy.getReports();
//	}

	
}


