import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/model/doctor';
import { DoctorDataService } from 'src/app/service/data/doctor-data.service';
import { Location } from '@angular/common';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent implements OnInit {

  doctor!: Doctor
  user!: User
  username!: string

  emailIdT!: boolean
  passwordT!: boolean
  firstNameT!: boolean
  lastNameT!: boolean
  genderT!: boolean
  addressT!: boolean
  dateOfBirthT!: boolean
  contactNumberT!: boolean

  dummyNumber!: number
  dummyDate!: Date

  errorMessageResponse!: string

  constructor(
    private authService: AuthenticationDataService,
    private userService: UserDataService,
    private doctorService: DoctorDataService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  navBack() {
    this.location.back();
  }

  ngOnInit(): void {
    this.doctor = new Doctor('', '', '', '', this.dummyDate, '', '', this.dummyNumber)
    this.username = this.authService.getLoggedInUserName();
    this.getUser();
  }

  getUser() {
    this.userService.getUserByUserName(this.username).subscribe(
      response => this.user = response
    )
  }

  doctorRegistration() {

    if(this.doctor.address===''){
      this.addressT=true
    }
    if(this.doctor.firstName===''){
      this.firstNameT=true
    }
    if(this.doctor.lastName===''){
      this.lastNameT=true
    }
    if(this.doctor.dateOfBirth===this.dummyDate){
      this.dateOfBirthT=true
    }
    if(this.doctor.emailId===''){
      this.emailIdT=true
    }
    if(this.doctor.contactNumber===this.dummyNumber){
      this.contactNumberT=true
    }
    if(this.doctor.gender===''){
      this.genderT=true
    }
    if(this.doctor.password===''){
      this.passwordT=true
    }

    // if(this.addressT==false && this.firstNameT==false && this.lastNameT==false && this.dateOfBirthT==false
    //    && this.emailIdT==false && this.contactNumberT==false && this.genderT==false && this.passwordT==false ) {
    this.doctorService.doctorRegistration(this.doctor).subscribe(
      response => {
        this.doctor = response
        this.router.navigate(['home'])
      },
      error => {
        if(error.error.message==='Email Id Already Exists'){
          this.errorMessageResponse = error.error.message
        } else {
          this.errorMessageResponse = 'Fields Required'
        }
        
      }
    )
      //  }
  }

  OnlyAlbhabets(event: any): boolean {

    const charCode = (event.which) ? event.which : event.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57) || charCode == ' ') {
      return true
    }


    return false;
  }

  OnlyNumbers(event: any): boolean {

    const charCode = (event.which) ? event.which : event.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false
    }


    return true;
  }
}
