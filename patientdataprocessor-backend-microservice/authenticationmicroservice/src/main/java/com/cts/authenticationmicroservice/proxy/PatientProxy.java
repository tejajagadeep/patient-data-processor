package com.cts.authenticationmicroservice.proxy;

import com.cts.authenticationmicroservice.model.Patient;
import com.cts.authenticationmicroservice.model.Report;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@FeignClient(name = "patients", url = "localhost:8085", path = "/api/v1.0/patient")
public interface PatientProxy {
	
    @GetMapping("")
    public List<Patient> getAllPatients();
    
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/contactNumber/{contactNumber}")
    public Patient getByContactNumber(@PathVariable Long contactNumber);
    
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
//    @GetMapping("/api/v1.0/patient/patientReports/{contactNumber}")
//    public Set<Report> getBypatientReports(@PathVariable Long contactNumber);
    
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PostMapping("/registerPatient")
    public Patient registerPatient(@RequestBody Patient patient);
    
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @PutMapping("/contactNumber/{contactNumber}")
    public Patient updatePatientDetails(@PathVariable Long contactNumber, @RequestBody Patient patient);
    
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @DeleteMapping("/contactNumber/{contactNumber}")
    public List<Patient> deletePatient(@PathVariable Long contactNumber);
}