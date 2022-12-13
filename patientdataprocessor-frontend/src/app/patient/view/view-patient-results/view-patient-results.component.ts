import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { ResultsDataService } from 'src/app/service/data/results-data.service';
import { Location } from '@angular/common';
import { Results } from 'src/app/model/results';
import { Patient } from 'src/app/model/patient';

@Component({
  selector: 'app-view-patient-results',
  templateUrl: './view-patient-results.component.html',
  styleUrls: ['./view-patient-results.component.css']
})
export class ViewPatientResultsComponent implements OnInit {

  results!: Results[]
  errorMessageResponse!: string
  dummyNumber!: number
  patient!: Patient
  contactNumber!: number
  deleteMessage!: string

  constructor(
    private resultsService: ResultsDataService,
    private patientService: PatientDataService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.getPatient(this.contactNumber)
    this.getAllResults(this.contactNumber)
  }

  navBack() {
    this.location.back();

  }

  getPatient(contactNumber1: number) {
    this.patientService.getByContactNumber(contactNumber1).subscribe(
      response => this.patient = response
    )
  }

  getAllResults(contactNumber1: number) {
    this.resultsService.getByContactNumber(contactNumber1).subscribe(
      response => this.results = response,
      error => {
        console.log(error.error.message.indexOf('Load balancer does not contain an instance for the service results'))
        console.log(error.error.message.indexOf('Connection refused:'))
        if (error.error.message.indexOf('Load balancer does not contain an instance for the service results')==123) {
          this.errorMessageResponse = 'Results Service Unavailable.'

        }
        if (error.error.message.indexOf('Connection refused:')==0) {
          this.errorMessageResponse = error.error.message

        }
        // console.log((this.errorMessageResponse))
      }
    )

        console.log((this.errorMessageResponse))
  }

  delete(id: number) {
    if (confirm('Are you sure you want delete?'))
      this.resultsService.delete(id).subscribe(
        response => {
          console.log(response),
            this.getAllResults(this.contactNumber)
          this.deleteMessage = `The Result is Deleted`
        }

      )
  }
}
