package com.cts.authenticationmicroservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.authenticationmicroservice.model.Results;

@FeignClient(name = "results", url = "localhost:8087", path = "/api/v1.0/results")
public interface ResultsProxy {

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("/contactNumber/{contactNumber}")
	public ResponseEntity<List<Results>> getByContactNumber(@PathVariable Long contactNumber);
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@PostMapping("/saveResults")
	public ResponseEntity<Results> saveResults(@RequestBody Results results);
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/id/{id}")
	public ResponseEntity<List<Results>> delete(@PathVariable int id);
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/contactNumber/{contactNumber}")
	public ResponseEntity<List<Results>> deleteAllByContactNumber(@PathVariable Long contactNumber);
}
