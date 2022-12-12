import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthenticationDataService } from '../auth/authentication-data.service';

@Injectable({
  providedIn: 'root'
})
export class DoctorAuthGuardService implements CanActivate {

  constructor(private router: Router,
    private authService: AuthenticationDataService) { }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const role = route.data['roles'] as Array<string>
    if (role && this.authService.isUserLoggedIn()) {
      const match = (localStorage.getItem('userRole') === role[0])
      if (match) {
        return true
      } else {
        this.router.navigate(['forbidden']);
        return false
      }
    }
    // if (this.authService.isUserLoggedIn())
    //   return true;

    this.router.navigate(['login']);
    return false;

  }
}