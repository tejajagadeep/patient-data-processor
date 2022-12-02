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

import com.cts.authenticationmicroservice.model.Report;

@FeignClient(name = "report", url = "localhost:8086")
public interface ReportProxy {
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/api/v1.0/report/getAllReports")
	public ResponseEntity<List<Report>> getAllReports();
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@PostMapping("/api/v1.0/report/saveReport/{contactNumber}")
	public ResponseEntity<Report> saveReport(@PathVariable Long contactNumber, @RequestBody Report report);
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@DeleteMapping("/api/v1.0/report/id/{id}")
	public ResponseEntity<List<Report>> delete(@PathVariable int id);
}
