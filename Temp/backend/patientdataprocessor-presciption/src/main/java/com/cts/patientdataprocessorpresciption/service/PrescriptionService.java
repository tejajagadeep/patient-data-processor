package com.cts.patientdataprocessorpresciption.service;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cts.patientdataprocessorpresciption.model.Prescription;
import com.cts.patientdataprocessorpresciption.repository.PrescriptionRepository;

import java.util.List;
@Service
public class PrescriptionService {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    public ResponseEntity<Prescription> getPrescription(String conditionName) {
        Prescription prescription = prescriptionRepository.findById(conditionName).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No prescription for condition " + conditionName + " exists in the database."));
        return ResponseEntity.ok(prescription);
    }

    public ResponseEntity<List<String>> getAllConditions() {
        return ResponseEntity.ok(prescriptionRepository.getAllConditions());
    }

	public PrescriptionService() {
		super();
	}
	public PrescriptionRepository getPrescriptionRepository() {
		return prescriptionRepository;
	}
	public void setPrescriptionRepository(PrescriptionRepository prescriptionRepository) {
		this.prescriptionRepository = prescriptionRepository;
	}
	
	
     
    
}
