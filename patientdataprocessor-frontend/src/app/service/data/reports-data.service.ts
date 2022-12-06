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

  getBycontactNumber(contactNumber: number) {
    return this.http.get<Report[]>(`${REPORT_API_URL}/contactNumber/${contactNumber}`)
  }

  saveReport(reports: Report) {
    return this.http.post<Report>(`${REPORT_API_URL}/saveReport`, reports)
  }

  deleteReport(id: number) {
    return this.http.delete<Report>(`${REPORT_API_URL}/id/${id}`)
  }

  deleteBycontactNumber(contactNumber: number) {
    return this.http.delete(`${REPORT_API_URL}/contactNumber/${contactNumber}`)
  }

  getChartInfo(contactNumber: number) {
    return this.http.get(`${REPORT_API_URL}/contactNumber/${contactNumber}`)
  }


}
