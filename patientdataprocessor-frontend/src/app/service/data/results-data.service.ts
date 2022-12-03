import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RESULTS_API_URL } from 'src/app/app.constants';
import { Results } from 'src/app/model/results';

@Injectable({
  providedIn: 'root'
})
export class ResultsDataService {

  constructor(
    private http: HttpClient
  ) { }

  getByContactNumber(contactNumber: number){
    return this.http.get<Results[]>(`${RESULTS_API_URL}/contactNumber/${contactNumber}`)
  }

  saveResults(results: Results){
    return this.http.post<Results>(`${RESULTS_API_URL}`,results)
  }

  delete(id: number){
    return this.http.delete<Results>(`${RESULTS_API_URL}/id/${id}`)
  }

  getChartInfo(contactNumber: number) {
    return this.http.get(`${RESULTS_API_URL}/contactNumber/${contactNumber}`)
  }

  deleteBycontactNumber(contactNumber: number){
    return this.http.delete(`${RESULTS_API_URL}/contactNumber/${contactNumber}`)
  }
}
