import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { USER_API_URL } from 'src/app/app.constants';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  constructor(
    private http: HttpClient
  ) { }

  getUserByUserName(userName: string) {
    return this.http.get<User>(`${USER_API_URL}/getUserByEmailId/${userName}`)
  }
}
