import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PATIENT_API_URL } from 'src/app/app.constants';
import { Patient } from 'src/app/model/patient';
import { Report } from 'src/app/model/report';

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

  updatePatientDetails(contactNumber: number,patient: Patient){
    return this.http.put<Patient>(`${PATIENT_API_URL}/updatePatientDetails/${contactNumber}`,patient)
  }

  deletePatient(contactNumber: number){
    return this.http.delete<Patient>(`${PATIENT_API_URL}/deletePatient/${contactNumber}`)
  }

  // getChartInfo(contactNumber: number) {
  //   return this.http.get("http://localhost:3000/patients");
  // }

  getChartInfo(contactNumber: number) {
    return this.http.get(`${PATIENT_API_URL}/patientReports/${contactNumber}`)
  }
}
