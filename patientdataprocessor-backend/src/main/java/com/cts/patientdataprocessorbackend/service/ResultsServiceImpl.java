package com.cts.patientdataprocessorbackend.service;

import java.util.Date;
import java.util.List;
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
	public List<Results> getByContactNumber(Long contactNumber) {
		if(resultsRepository.findByContactNumber(contactNumber)==null) {
			throw new NoSuchElementException("Patient doesn't exist");
		}
		return resultsRepository.findByContactNumber(contactNumber);
	}

	@Override
	public Results saveResults(Results results) {
//		if(resultsRepository.findByContactNumber(results.getContactNumber())!=null) {
//			throw new IdAlredyExistsException("Patient doesn't exist");
//		}
		results.setDate(new Date());
		return resultsRepository.save(results);
	}

	@Override
	public List<Results> delete(int id) {
		resultsRepository.deleteById(id);
		return resultsRepository.findAll();
	}
	
	
}
