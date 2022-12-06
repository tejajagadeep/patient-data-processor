package com.cts.authenticationmicroservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.authenticationmicroservice.model.Prescription;

@FeignClient(name = "presciptions", url = "localhost:8088")
public interface PrescriptionProxy {

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
	@GetMapping("/api/v1.0/prescription")
    public ResponseEntity<List<String>> getAllConditions();

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
    @GetMapping("/api/v1.0/prescription/conditionName/{conditionName}")
    public ResponseEntity<Prescription> getPrescription(@PathVariable String conditionName);
}
