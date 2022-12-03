import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DOCTOR_API_URL } from 'src/app/app.constants';
import { Doctor } from 'src/app/model/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorDataService {

  constructor(
    private http: HttpClient
  ) { }

  retrieveAllDoctorDetails(){
    return this.http.get<Doctor[]>(`${DOCTOR_API_URL}/`) 
  }

  retrieveDoctorDetailsById(emailId: string){
    return this.http.get<Doctor>(`${DOCTOR_API_URL}/emailId/${emailId}`) 
  }

  doctorRegistration(doctor: Doctor){
    return this.http.post<Doctor>(`${DOCTOR_API_URL}/doctorRegistration`,doctor) 
  }

}
