package com.cts.authenticationmicroservice.proxy;

import com.cts.authenticationmicroservice.model.Patient;
import com.cts.authenticationmicroservice.model.Report;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@FeignClient(name = "patient", url = "localhost:8085")
public interface PatientProxy {
	
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
    @GetMapping("/api/v1.0/patient")
    public List<Patient> getAllPatients();
    
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
    @GetMapping("/api/v1.0/patient/contactNumber/{contactNumber}")
    public Patient getByContactNumber(@PathVariable Long contactNumber);
    
//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
//    @GetMapping("/api/v1.0/patient/patientReports/{contactNumber}")
//    public Set<Report> getBypatientReports(@PathVariable Long contactNumber);
    
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
    @PostMapping("/api/v1.0/patient/registerPatient")
    public Patient registerPatient(@RequestBody Patient patient);
    
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
    @PutMapping("/api/v1.0/patient/contactNumber/{contactNumber}")
    public Patient updatePatientDetails(@PathVariable Long contactNumber, @RequestBody Patient patient);
    
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')")
    @DeleteMapping("/api/v1.0/patient/contactNumber/{contactNumber}")
    public List<Patient> deletePatient(@PathVariable Long contactNumber);
}