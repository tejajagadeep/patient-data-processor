import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationDataService } from '../auth/authentication-data.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthService implements HttpInterceptor {

  constructor(
    private authDataService: AuthenticationDataService
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    let basicAuthHeaderString = this.authDataService.getAuthenticatedToken();
    let username = this.authDataService.getLoggedInUserName()

    if (basicAuthHeaderString && username) {
      request = request.clone({
        setHeaders: {
          Authorization: basicAuthHeaderString
        }
      })
    }
    return next.handle(request);
  }

  // intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {


  //   if (this.authDataService.isUserLoggedIn() && (req.url.indexOf('basicauth') === -1)) {
  //     const authReq = req.clone({
  //       headers: new HttpHeaders({
  //         'Content-Type': 'application/json',
  //         'Authorization': `Basic ${window.btoa(this.authDataService.username + ":" + this.authDataService.password)}`
  //       })
  //     });
  //     return next.handle(authReq);
  //   } else {
  //     return next.handle(req);
  //   }
  // }


  // intercept(req: HttpRequest<any>, next: HttpHandler) {

  //   if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
  //     req = req.clone({
  //       setHeaders: {
  //         Authorization: sessionStorage.getItem('token')
  //       }
  //     })
  //   }

  //   return next.handle(req);

  // }
}

