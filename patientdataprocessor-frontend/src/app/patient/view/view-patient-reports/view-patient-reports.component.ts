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
      response => this.report = response
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
