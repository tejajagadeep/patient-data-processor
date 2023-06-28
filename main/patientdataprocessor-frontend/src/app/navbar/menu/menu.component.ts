import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  username!: string
  user!: User
  constructor(
    private router: Router,
    private authService: AuthenticationDataService,
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    this.username = this.authService.getLoggedInUserName();
    this.getUser();
  }

  getUser() {
    this.userService.getUserByUserName(this.username).subscribe(
      response => this.user = response
    )
  }

  logout() {
    this.router.navigate(['logout'])
  }
}
