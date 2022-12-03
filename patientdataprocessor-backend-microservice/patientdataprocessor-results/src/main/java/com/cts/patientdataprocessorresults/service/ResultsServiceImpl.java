package com.cts.patientdataprocessorresults.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessorresults.model.Results;
import com.cts.patientdataprocessorresults.repository.ResultsRepository;

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

	@Override
	public List<Results> deleteAllByContactNumber(Long contactNumber) {
		resultsRepository.findByContactNumber(contactNumber).forEach(resultsEach->{
			resultsRepository.deleteAll(resultsRepository.findByContactNumber(contactNumber));
		});
		return resultsRepository.findAll();
	}
	
	
}
