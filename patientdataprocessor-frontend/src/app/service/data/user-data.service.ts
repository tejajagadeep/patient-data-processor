import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  constructor(
    private http: HttpClient
  ) { }

  getUserByUserName(userName: string){
    return this.http.get<User>(`http://localhost:8091/patient-data-processor/getUserByEmailId/${userName}`)
  }
}
