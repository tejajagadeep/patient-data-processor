import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { Report } from 'src/app/model/report';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { ReportsDataService } from 'src/app/service/data/reports-data.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-view-patient-reports',
  templateUrl: './view-patient-reports.component.html',
  styleUrls: ['./view-patient-reports.component.css']
})
export class ViewPatientReportsComponent implements OnInit {

  patient!: Patient

  report!: Report[]
  errorMessageResponse!: string
  

  contactNumber!: number

  constructor(
    private patientService: PatientDataService,
    private router: Router,
    private route: ActivatedRoute,
    private location: Location,
    private reportService: ReportsDataService
  ) { }

  navBack() {
    this.location.back();
  }

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.getPatient(this.contactNumber)
    this.getReports(this.contactNumber)
  }

  getPatient(contactNumber1: number) {
    this.patientService.getByContactNumber(contactNumber1).subscribe(
      response => this.patient = response
    )
  }

  getReports(contactNumber1: number) {
    this.reportService.getBycontactNumber(contactNumber1).subscribe(
      response => {
        this.report = response,
          console.log(response)
      },
      error => {
        console.log(error.error.message.indexOf('Load balancer does not contain an instance for the service reports'))
        console.log(error.error.message.indexOf('Connection refused:'))
        if (error.error.message.indexOf('Load balancer does not contain an instance for the service reports')==124) {
          this.errorMessageResponse = 'Reports Service Unavailable.'

        }
        if (error.error.message.indexOf('Connection refused:')==0) {
          this.errorMessageResponse = error.error.message

        }
        console.log((this.errorMessageResponse))
      }
    )
    
  }

  delete(id: number) {
    if (confirm('Are you sure want to delete?')) {
      this.reportService.deleteReport(id).subscribe(
        response => {
          console.log(response),
          this.getReports(this.contactNumber)
        }
      )
    }
  }
}
