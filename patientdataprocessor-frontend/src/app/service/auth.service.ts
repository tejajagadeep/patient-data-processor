import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loginUrl : string = '';
  signUpUrl : string = '';

  constructor(private http : HttpClient) {

    this.loginUrl = "http://localhost:8051/auth/login";
    this.signUpUrl = "http://localhost:8051/auth/register";
    

  }
  
  login(user : User) : Observable<any> {
    return this.http.post<any>(this.loginUrl,user);
  }
  isLoggedIn()
  {
    let token = localStorage.getItem("token");
    if(token==undefined || token===''|| token==null)
    {
      return false;
    }
    else{
      return true;
    }
  }
  getToken()
  {
    return localStorage.getItem('token');
  }

  signUp(user : User) : Observable<any> {
    return this.http.post<any>(this.signUpUrl,user);
  }

}

