import { Component, OnInit, VERSION } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { fromEvent } from 'rxjs';
import { debounceTime, map, tap } from 'rxjs/operators';
import { Doctor } from '../model/doctor';
import { Patient } from '../model/patient';
import { User } from '../model/user';
import { AuthenticationDataService } from '../service/auth/authentication-data.service';
import { DoctorDataService } from '../service/data/doctor-data.service';
import { PatientDataService } from '../service/data/patient-data.service';
import { ReportsDataService } from '../service/data/reports-data.service';
import { ResultsDataService } from '../service/data/results-data.service';
import { UserDataService } from '../service/data/user-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  patients!: Patient[]
  doctors!: Doctor[]
  doctor!: Doctor
  //user
  username!: string
  user!: User
  searchText: any;
  constructor(
    private patietnService: PatientDataService,
    private resultsService: ResultsDataService,
    private reportsService: ReportsDataService,
    private authService: AuthenticationDataService,
    private userService: UserDataService,
    private doctorService: DoctorDataService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.username = this.authService.getLoggedInUserName();
    // this.getdoctorById(this.username)
    this.getUser();
    this.getAllPatients();
    this.getAllDoctors();
  }

  getUser() {
    this.userService.getUserByUserName(this.username).subscribe(
      response => this.user = response
    )
  }

  getAllPatients() {
    this.patietnService.getAllPatient().subscribe(
      response => {
        this.patients = response,
          console.log(response)
      }
    )
  }

  getdoctorById(email: string){
    this.doctorService.retrieveDoctorDetailsById(email).subscribe(
      response => this.doctor = response
    )
  }

  getAllDoctors() {
    this.doctorService.retrieveAllDoctorDetails().subscribe(
      response => {
        this.doctors = response,
          console.log(response)
      }
    )
  }

  deletePatient(contactNumber1: number) {
    if (confirm(`Are you sure you want to Delete Patient?`)) {
      this.patietnService.deletePatient(contactNumber1).subscribe(
        response => {
          console.log(response),
            this.getAllPatients()
        },
        error => console.log(error)
      )
      this.resultsService.deleteBycontactNumber(contactNumber1).subscribe(
        response => {
          console.log(response)
        }
      )
      this.reportsService.deleteBycontactNumber(contactNumber1).subscribe(
        response => {
          console.log(response)
        }
      )
    }
  }

  logout() {
    this.authService.logOut()
    this.router.navigate(['logout'])
  }

  name = 'Angular ' + VERSION.major;

  showBtn$ = fromEvent(document, 'scroll').pipe(
    debounceTime(50),
    map(() => window.scrollY > 500),
    tap(() => console.log('sas'))
  );

  // not Cross browsing (works on chrome - firefox)
  gotoTop() {
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth',
    });
  }
}
