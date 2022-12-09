import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Report } from 'src/app/model/report';
import { ReportsDataService } from 'src/app/service/data/reports-data.service';
import { Location } from '@angular/common';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { Patient } from 'src/app/model/patient';

@Component({
  selector: 'app-reports-registration',
  templateUrl: './reports-registration.component.html',
  styleUrls: ['./reports-registration.component.css']
})
export class ReportsRegistrationComponent implements OnInit {

  reports!: Report
  patient!: Patient
  contactNumber!: number
  errorMessageResponse!: string
  dummyNumber!: number
  dummyDate!: DateConstructor

  systolicT= false
  diastolicT= false
  sugarlevelT= false
  sugarlevel2T= false

  constructor(
    private reportsService: ReportsDataService,
    private patientService: PatientDataService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  navBack() {
    this.location.back();

  }

  getPatient(contactNumber1: number) {
    this.patientService.getByContactNumber(contactNumber1).subscribe(
      response => this.patient = response
    )
  }

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.reports = new Report(this.dummyNumber, this.dummyNumber, this.dummyDate, this.dummyNumber, this.dummyNumber, this.dummyNumber, this.dummyNumber)
    this.getPatient(this.contactNumber)
  }

  saveReports() {

    if(this.reports.systolic===this.dummyNumber){
      this.systolicT=true
    }
    if(this.reports.diastolic===this.dummyNumber){
      this.diastolicT=true
    }
    if(this.reports.sugarlevel===this.dummyNumber){
      this.sugarlevelT=true
    }
    if(this.reports.sugarlevel2===this.dummyNumber){
      this.sugarlevel2T=true
    }

    // if(this.systolicT===false && this.diastolicT===false && this.sugarlevelT===false && this.sugarlevel2T===false){
      if(this.reports.systolic!==this.dummyNumber && this.reports.diastolic!==this.dummyNumber 
        && this.reports.sugarlevel!==this.dummyNumber && this.reports.sugarlevel2!==this.dummyNumber){
    this.reports.contactNumber = this.contactNumber
    this.reportsService.saveReport(this.reports).subscribe(
      repsonse => {
        console.log(repsonse)
        // repsonse.day = new Date()
        this.router.navigate(['view-patient-reports', this.contactNumber])
      },
      error => this.errorMessageResponse = error.error.message
    )
  }
}

}
