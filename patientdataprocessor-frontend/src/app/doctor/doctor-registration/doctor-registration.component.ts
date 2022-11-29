import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/model/doctor';
import { DoctorDataService } from 'src/app/service/data/doctor-data.service';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent implements OnInit {

  doctor!: Doctor

  dummyNumber!: number
  dummyDate!: Date

  errorMessageResponse!: string

  constructor(
    private doctorService: DoctorDataService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.doctor = new Doctor('','','','',this.dummyDate,'','','',this.dummyNumber)
  }

  doctorRegistration(){
    this.doctorService.doctorRegistration(this.doctor).subscribe(
      response=>{
        this.doctor = response
      },
      error => this.errorMessageResponse = error.error.message
    )
  }

  OnlyAlbhabets(event: any):boolean{

    const charCode = (event.which)?event.which: event.keyCode;

    if(charCode > 31 && (charCode < 48 || charCode > 57) || charCode == ' ') {
       return true
    }


    return false;
  }
}
