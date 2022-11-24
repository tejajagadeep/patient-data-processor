import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { MessageResponse } from 'src/app/model/message-response';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationDataService {

  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public username!: string
  public password!: string;

  messageResponse!: MessageResponse

  constructor(
    // private http: HttpClient,
    private httpClient: HttpClient
  ) { }

  authenticate(username: string, password: string) {
    return this.httpClient.post<any>('http://localhost:8091/patient-data-processor/authenticate', { username, password }).pipe(
      map(
        userData => {
          sessionStorage.setItem('authenticatedUser', username);
          let tokenStr = 'Bearer ' + userData.token;
          sessionStorage.setItem('token', tokenStr);
          return userData;
        }
      )

    );
  }

  getAuthenticatedToken() {
    return sessionStorage.getItem('token')
  }

  isUserLoggedIn() {
    // let user = sessionStorage.getItem('username')
    // console.log(!(user === null))
    // return !(user === null)
    let user = sessionStorage.getItem('authenticatedUser')
    if (user === null) return false
    return true
  }

  logOut() {
    sessionStorage.removeItem('authenticatedUser')
    sessionStorage.removeItem('token')
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
  }

  authenticationService(username: string, password: string): Observable<any> {
    return this.httpClient.get(`http://localhost:8091/patient-data-processor/basicauth`,
      { headers: { authorization: this.createBasicAuthToken1(username, password) } }).pipe(map((res) => {
        this.username = username;
        this.password = password;
        this.registerSuccessfulLogin1(username, password);
      }));
  }

  createBasicAuthToken1(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin1(username: string, password: string) {
    sessionStorage.setItem('authenticatedUser', username)
    // sessionStorage.setItem('password',password)
  }

  logout1() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    // this.username = null;
    // this.password = null;
  }

  isUserLoggedIn1() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  isNavBar() {
    let user = sessionStorage.getItem('authenticatedUser')
    if (user) { return false } else {
      return true
    }
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem('authenticatedUser')
    if (user === null) return ''
    return user
  }
}
