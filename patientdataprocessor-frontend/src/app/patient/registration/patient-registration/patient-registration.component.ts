import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-patient-registration',
  templateUrl: './patient-registration.component.html',
  styleUrls: ['./patient-registration.component.css']
})
export class PatientRegistrationComponent implements OnInit {

  patient!: Patient

  dummyNumber!: number
  dummyDate!: Date

  errorMessageResponse!: string

  constructor(
    private patientService: PatientDataService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  navBack() {
    this.location.back();
  }

  ngOnInit(): void {
    this.patient = new Patient(this.dummyNumber, '', '', '', '', this.dummyDate, '', this.dummyNumber, '', '', '', '', '', this.dummyDate, this.dummyDate, this.dummyDate, '', '', '')
  }

  OnlyAlbhabets(event: any): boolean {

    const charCode = (event.which) ? event.which : event.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57) || charCode == ' ') {
      return true
    }


    return false;
  }

  OnlyNumbers(event: any): boolean {

    const charCode = (event.which) ? event.which : event.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false
    }


    return true;
  }

  savepatient() {
    this.patientService.registerPatient(this.patient).subscribe(
      response => {
        this.patient = response
        this.router.navigate(['view-patient-details', response.contactNumber])
      },
      error => this.errorMessageResponse = error
    )

  }
}
