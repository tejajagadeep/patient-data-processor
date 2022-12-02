import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Results } from 'src/app/model/results';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { ReportsDataService } from 'src/app/service/data/reports-data.service';

@Component({
  selector: 'app-results-registration',
  templateUrl: './results-registration.component.html',
  styleUrls: ['./results-registration.component.css']
})
export class ResultsRegistrationComponent implements OnInit {

  results!: Results
  dummyNumber!: number
  contactNumber!: number

  constructor(
    private resultsService: ReportsDataService,
    private patientService: PatientDataService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

}
