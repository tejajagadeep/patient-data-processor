import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthenticationDataService } from './authentication-data.service';

@Injectable({
  providedIn: 'root'
})
export class LoginRouteGuardService implements CanActivate {

  constructor(private router: Router,
    private authService: AuthenticationDataService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (!(this.authService.isUserLoggedIn()))
      return true;

    this.router.navigate(['home']);
    return false;
  }
}
