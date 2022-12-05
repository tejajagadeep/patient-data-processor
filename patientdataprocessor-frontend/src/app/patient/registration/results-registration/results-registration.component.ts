import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { Results } from 'src/app/model/results';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { ResultsDataService } from 'src/app/service/data/results-data.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-results-registration',
  templateUrl: './results-registration.component.html',
  styleUrls: ['./results-registration.component.css']
})
export class ResultsRegistrationComponent implements OnInit {

  results!: Results
  errorMessageResponse!: string
  dummyNumber!: number
  patient!: Patient
  contactNumber!: number
  dummyDate!: DateConstructor

  constructor(
    private resultsService: ResultsDataService,
    private patientService: PatientDataService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.results = new Results(this.dummyNumber,this.dummyNumber,this.dummyNumber,this.dummyNumber,this.dummyNumber,this.dummyNumber,this.dummyNumber,this.dummyNumber,this.dummyNumber,this.dummyNumber,this.dummyDate)
  this.getPatient(this.contactNumber)
}
OnlyNumbers(event: any):boolean{

  const charCode = (event.which)?event.which: event.keyCode;

  if(charCode < 31 && (charCode < 48 || charCode > 57)  || charCode == '.') {
     return true
  }


  return false;
}
getPatient(contactNumber1: number){
  this.patientService.getByContactNumber(contactNumber1).subscribe(
    response=> this.patient=response
  )
}
  saveResults(){
    this.results.contactNumber = this.contactNumber;
    this.resultsService.saveResults(this.results).subscribe(
      repsonse=> {
        console.log(repsonse)
        // repsonse.day = new Date()
        this.router.navigate(['view-patient-results',this.contactNumber ])
      },
      error => this.errorMessageResponse = error.error.message
    )
  }

  navBack(){
    this.location.back();
    
  }
}
