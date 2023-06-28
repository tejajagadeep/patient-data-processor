package com.cts.patientdataprocessor.dto;


import javax.validation.constraints.Size;
import java.util.Date;

public class PatientDto {
    private Long contactNumber;

    private String address;

    private String firstName;

    private String lastName;

    private String gender;

    private Date dateOfBirth;

    private String maritalStatus;

//	private String additioanlNote;

    private Long emergencyContactNumber;

    private String email;

    private String bloodGroup;

//	private String Bpcheck;

//	private String bloodSugarLvls;

    private String disease;

    private String diagnosis;

    @Size(max = 500)
    private String previousDiagnosis;

    private Date dateVisited;

    private Date treatmentStartDate;

    private Date treatmentEndDate;

    private String prescription;

//	private String reports;

    private String height;

    private String weight;
}
