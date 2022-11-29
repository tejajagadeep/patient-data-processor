import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from '../model/doctor';
import { Patient } from '../model/patient';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { DoctorDataService } from '../service/data/doctor-data.service';
import { PatientDataService } from '../service/data/patient-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  patients!: Patient[]
  doctors!: Doctor[]
  //user
  username!: string
  user!: User

  constructor(
    private patietnService: PatientDataService,
    private authService: AuthenticationDataService,
    private userService: UserDataService,
    private doctorService: DoctorDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.username = this.authService.getLoggedInUserName();
    this.getUser();
    this.getAllPatients();
    this.getAllDoctors();
  }

  getUser(){
    this.userService.getUserByUserName(this.username).subscribe(
      response=> this.user=response
    )
  }

  getAllPatients(){
    this.patietnService.getAllPatient().subscribe(
      response=> {
        this.patients=response,
        console.log(response)
      }
    )
  }

  getAllDoctors(){
    this.doctorService.retrieveAllDoctorDetails().subscribe(
      response=> {
        this.doctors=response,
        console.log(response)
      }
    )
  }

  logout(){
    this.authService.logOut()
  }
}
