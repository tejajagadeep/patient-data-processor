import { HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticationDataService } from './authentication-data.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterService implements HttpInterceptor {

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
}
