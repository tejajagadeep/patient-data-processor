import { Component, OnInit } from '@angular/core';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private AuthService: AuthenticationDataService
  ) { }

  ngOnInit(

  ): void {

    this.AuthService.logOut();

  }

}
