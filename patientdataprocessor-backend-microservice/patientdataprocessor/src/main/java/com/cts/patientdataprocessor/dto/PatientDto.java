package com.cts.patientdataprocessor.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class PatientDto implements Serializable {

    private static final long serialVersionUID = -952462343447920874L;

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

    private String previousDiagnosis;

    private Date dateVisited;

    private Date treatmentStartDate;

    private Date treatmentEndDate;

    private String prescription;

//	private String reports;

    private String height;

    private String weight;
}
