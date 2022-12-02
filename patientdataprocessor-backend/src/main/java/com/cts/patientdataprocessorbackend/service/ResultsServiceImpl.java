package com.cts.patientdataprocessorbackend.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessorbackend.exception.IdAlredyExistsException;
import com.cts.patientdataprocessorbackend.model.Results;
import com.cts.patientdataprocessorbackend.repository.ResultsRepository;

@Service
public class ResultsServiceImpl implements ResultsService{
	
	@Autowired
	ResultsRepository resultsRepository;

	@Override
	public Results getByContactNumber(Long contactNumber) {
		if(resultsRepository.findByContactNumber(contactNumber)==null) {
			throw new NoSuchElementException("Patient doesn't exist");
		}
		return resultsRepository.findByContactNumber(contactNumber);
	}

	@Override
	public Results saveResults(Results results) {
		if(resultsRepository.findByContactNumber(results.getContactNumber())!=null) {
			throw new IdAlredyExistsException("Patient doesn't exist");
		}
		return resultsRepository.save(results);
	}
	
	
}
