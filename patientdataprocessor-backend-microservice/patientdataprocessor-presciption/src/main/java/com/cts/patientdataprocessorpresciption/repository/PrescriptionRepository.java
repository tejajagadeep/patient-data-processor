package com.cts.patientdataprocessorpresciption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.patientdataprocessorpresciption.model.Prescription;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, String > {

    @Query("select condition from Prescription")
    public List<String> getAllConditions();
    
}
