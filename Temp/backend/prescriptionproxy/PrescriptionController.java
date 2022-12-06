package com.cts.authenticationmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authenticationmicroservice.model.Prescription;
import com.cts.authenticationmicroservice.proxy.PrescriptionProxy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionProxy prescriptionProxy;

    @Operation(summary = "Retrieve Prescriptions", description = "Retrieve all the Prescriptions from the data base.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
    @GetMapping("")
    public ResponseEntity<List<String>> getAllConditions(){
        return this.prescriptionProxy.getAllConditions();
    }

    @Operation(summary = "Retrieve Prescription's Details", description = "Retrieve a Prescription details from the data base.")
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
    @GetMapping("/conditionName/{conditionName}")
    public ResponseEntity<Prescription> getPrescription(@PathVariable String conditionName){
        return this.prescriptionProxy.getPrescription(conditionName);
    }

}
