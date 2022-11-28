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
  
  constructor(
    private patientService: PatientDataService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.patient = new Patient(this.dummyNumber, '','','','',this.dummyDate,'',this.dummyNumber,'','','',this.dummyDate,this.dummyDate,this.dummyDate,'','','',[])
  }

  savepatient(){
    this.patientService.registerPatient(this.patient).subscribe(
      response=> this.patient=response,
      error=> this.errorMessageResponse = error
    )

  }
}
