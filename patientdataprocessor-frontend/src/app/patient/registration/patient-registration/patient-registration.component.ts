import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-patient-registration',
  templateUrl: './patient-registration.component.html',
  styleUrls: ['./patient-registration.component.css']
})
export class PatientRegistrationComponent implements OnInit {

  patient!: Patient

  dummyNumber!: number
  dummyDate!: Date

  errorMessageResponse!: string
  errorDummy!: string

  contactNumberT = false
  addressT = false
  firstNameT = false
  lastNameT = false
  genderT = false
  dateOfBirthT = false
  maritalStatusT = false
  emailT = false
  bloodGroupT = false

  constructor(
    private patientService: PatientDataService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) { }

  navBack() {
    this.location.back();
  }

  ngOnInit(): void {
    this.patient = new Patient(this.dummyNumber, '', '', '', '', this.dummyDate, '', this.dummyNumber, '', '', '', '', '', this.dummyDate, this.dummyDate, this.dummyDate, '', '', '')
  }

  OnlyAlbhabets(event: any): boolean {

    const charCode = (event.which) ? event.which : event.keyCode;

    if (charCode == 32 || ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))) {
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

  savepatient() {

    if (this.patient.firstName === '') {
      this.firstNameT = true
    }
    if (this.patient.lastName === '') {
      this.lastNameT = true
    }
    if (this.patient.contactNumber === this.dummyNumber) {
      this.contactNumberT = true
    }
    if (this.patient.address === '') {
      this.addressT = true
    }
    if (this.patient.email === '') {
      this.emailT = true
    }
    if (this.patient.dateOfBirth === this.dummyDate) {
      this.dateOfBirthT = true
    }
    if (this.patient.gender === '') {
      this.genderT = true
    }
    if (this.patient.maritalStatus === '') {
      this.maritalStatusT = true
    }
    if (this.patient.bloodGroup === '') {
      this.bloodGroupT = true
    }

    if (this.patient.firstName !== '' && this.patient.lastName !== '' && this.patient.contactNumber !== this.dummyNumber &&
      this.patient.address !== '' && this.patient.email !== '' && this.patient.dateOfBirth !== this.dummyDate &&
      this.patient.gender !== '' && this.patient.maritalStatus !== '' && this.patient.bloodGroup !== '') {
      this.patientService.registerPatient(this.patient).subscribe(
        response => {
          this.patient = response
          this.router.navigate(['view-patient-details', response.contactNumber])
        },
        error => {
          this.errorDummy = error.error.message
          this.errorDummy = this.errorDummy.slice(279)
          console.log()
          this.errorMessageResponse = this.errorDummy.substring(0,this.errorDummy.indexOf('.'))
         if (error.error.message.indexOf('Load balancer does not contain an instance for the service patients')==116) {
          this.errorMessageResponse = 'Patient Service Unavailable.'

        }
      }
      )
    }
  }
}
