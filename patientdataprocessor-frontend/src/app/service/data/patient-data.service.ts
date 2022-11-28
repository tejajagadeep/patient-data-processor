import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PATIENT_API_URL } from 'src/app/app.constants';
import { Patient } from 'src/app/model/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientDataService {

  constructor(
    private http: HttpClient
  ) { }

  getAllPatient(){
    return this.http.get<Patient[]>(`${PATIENT_API_URL}/getAllPatients`)
  }

  getByContactNumber(contactNumber: number){
    return this.http.get<Patient>(`${PATIENT_API_URL}/getByContactNumber/${contactNumber}`)
  }

  registerPatient(patient: Patient){
    return this.http.post<Patient>(`${PATIENT_API_URL}/registerPatient`,patient)
  }

}
