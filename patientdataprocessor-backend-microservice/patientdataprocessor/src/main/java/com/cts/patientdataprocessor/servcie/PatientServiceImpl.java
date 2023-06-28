package com.cts.patientdataprocessor.servcie;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import com.cts.patientdataprocessor.dto.PatientDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessor.exception.IdAlredyExistsException;
import com.cts.patientdataprocessor.model.Patient;
import com.cts.patientdataprocessor.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepository patientRepository;

	Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	
	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}


	@Override
	public Patient getByContactNumber(Long contactNumber) {
		return patientRepository.findByContactNumber(contactNumber);
	}


	@Override
	public PatientDto registerPatient(PatientDto patientDto) {

		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		Patient patientDummy = patientRepository.findByContactNumber(patientDto.getContactNumber());
//		log.trace(patientDummy.getContactNumber().toString());
//		log.trace(patientDummy.getEmail());
		log.warn("true = "+(patientRepository.findByContactNumber(patientDto.getContactNumber())));
//		if(patientRepository.findByContactNumber(patientDto.getContactNumber())!=null) {
//			throw new  IdAlredyExistsException("Contact Number Already Exists.");
//		}
//		if(patientRepository.findByEmail(patientDto.getEmail())!=null) {
//			throw new  IdAlredyExistsException("Email Id Already Exists.");
//		}
		if(patientRepository.findByContactNumber(patientDto.getContactNumber())==null && patientRepository.findByEmail(patientDto.getEmail())==null) {
			Patient patient = modelMapper.map(patientDto, Patient.class);
			patientRepository.save(patient);
		}

		return patientDto;
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


