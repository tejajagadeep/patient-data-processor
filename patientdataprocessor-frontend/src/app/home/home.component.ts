import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientDataService } from '../service/data/patient-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  patients!: Patient[]

  constructor(
    private patietnService: PatientDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getAllPatients()
  }

  getAllPatients(){
    this.patietnService.getAllPatient().subscribe(
      response=> {
        this.patients=response,
        console.log(response)
      }
    )
  }
}
