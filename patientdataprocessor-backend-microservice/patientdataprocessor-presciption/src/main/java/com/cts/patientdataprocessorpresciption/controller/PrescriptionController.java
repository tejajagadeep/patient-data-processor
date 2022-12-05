package com.cts.patientdataprocessorpresciption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.patientdataprocessorpresciption.model.Prescription;
import com.cts.patientdataprocessorpresciption.service.PrescriptionService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    @GetMapping("")
    public ResponseEntity<List<String>> getAllConditions(){
        return prescriptionService.getAllConditions();
    }

    @GetMapping("/conditionName/{conditionName}")
    public ResponseEntity<Prescription> getPrescription(@PathVariable String conditionName){
        return prescriptionService.getPrescription(conditionName);
    }
}
