import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { PatientDataService } from 'src/app/service/data/patient-data.service';

@Component({
  selector: 'app-patient-records-registration',
  templateUrl: './patient-records-registration.component.html',
  styleUrls: ['./patient-records-registration.component.css']
})
export class PatientRecordsRegistrationComponent implements OnInit {

  patient!: Patient
  dummyNumber!: number
  dummyDate!: Date
  errorMessageResponse!: string
  contactNumber!: number
  
  constructor(
    private patientService: PatientDataService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.getPatient(this.contactNumber)
  }

  getPatient(contactNumber1: number){
    this.patientService.getByContactNumber(contactNumber1).subscribe(
      response=> this.patient=response
    )
  }

  savepatient(){
    this.patientService.updatePatientDetails(this.contactNumber,this.patient).subscribe(
      response=> this.patient=response,
      error=> this.errorMessageResponse = error
    )

  }
}
