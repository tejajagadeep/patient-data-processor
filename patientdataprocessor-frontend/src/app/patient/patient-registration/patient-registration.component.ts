import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { PatientDataService } from 'src/app/service/data/patient-data.service';

@Component({
  selector: 'app-patient-registration',
  templateUrl: './patient-registration.component.html',
  styleUrls: ['./patient-registration.component.css']
})
export class PatientRegistrationComponent implements OnInit {

  patient!: Patient

  errorMessageResponse!: string

  constructor(
    private patientService: PatientDataService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

  OnlyAlbhabets(event: any):boolean{

    const charCode = (event.which)?event.which: event.keyCode;

    if(charCode > 31 && (charCode < 48 || charCode > 57) || charCode == ' ') {
       return true
    }


    return false;
  }

  savepatient(){
    this.patientService.registerPatient(this.patient).subscribe(
      response=> this.patient=response,
      error=> this.errorMessageResponse = error
    )

  }
}
