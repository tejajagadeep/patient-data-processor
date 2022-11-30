import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Report } from 'src/app/model/report';
import { ReportsDataService } from 'src/app/service/data/reports-data.service';

@Component({
  selector: 'app-reports-registration',
  templateUrl: './reports-registration.component.html',
  styleUrls: ['./reports-registration.component.css']
})
export class ReportsRegistrationComponent implements OnInit {

  reports!: Report
  contactNumber!: number
  errorMessageResponse!: string
  dummyNumber!: number
  dummyDate!: Date

  constructor(
    private reportsService: ReportsDataService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.reports = new Report(this.dummyNumber,this.dummyDate,this.dummyNumber,this.dummyNumber,this.dummyNumber)
  }

  saveReports(){
    this.reportsService.saveReport(this.contactNumber,this.reports).subscribe(
      repsonse=> {
        console.log(repsonse)
        // repsonse.day = new Date()
      },
      error => this.errorMessageResponse = error.error.message
    )
  }

}
