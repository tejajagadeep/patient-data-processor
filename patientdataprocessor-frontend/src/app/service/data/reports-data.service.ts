import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { REPORT_API_URL } from 'src/app/app.constants';
import { Report } from 'src/app/model/report';

@Injectable({
  providedIn: 'root'
})
export class ReportsDataService {

  constructor(
    private http: HttpClient
  ) { }

  saveReport(contactNumber: number,reports: Report){
    return this.http.post<Report>(`${REPORT_API_URL}/saveReport/${contactNumber}`,reports)
  }

  deleteReport(id: number){
    return this.http.delete<Report>(`${REPORT_API_URL}/id/${id}`)
  }
}
