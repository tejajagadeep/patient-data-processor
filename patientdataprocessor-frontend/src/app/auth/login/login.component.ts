import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/service/auth.service';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  role: string = '';

  isLoggedIn = false

  user: User = new User();

  roles: string[];

  constructor(
    private authService: AuthService,
    private route: Router,
    private authSerice: AuthenticationDataService,
    private userService: UserDataService
  ) {
    this.roles = [
      'admin',
      'user'
    ]
  }

  ngOnInit(): void {
    this.username = '';
    this.password = '';
    this.isLoggedIn = this.authSerice.isUserLoggedIn();
  }

  login() {
    // this.user.username = this.username;
    // this.user.password = this.password;
    this.user.role = this.role;

    this.authService.login(this.user).subscribe(res => {
      console.log(res);
      if (res == null) {
        alert("Username or password is wrong");
        this.ngOnInit();
      } else {
        console.log("Login successful");
        localStorage.setItem("token", res.token);
        localStorage.setItem("username", res.username);
        // response.role === 'ADMIN'
        if (this.role == 'user') {
          this.route.navigate(['/user']);
        }

        if (this.role == 'admin') {
          this.route.navigate(['/admin']);
        }

      }

    }, err => {
      alert("Login failed");
      this.ngOnInit();
    })

  }

  loginUser() {
    this.authSerice.authenticate(this.username, this.password).subscribe(
      reponse => {
        this.userService.getUserByUserName(this.username).subscribe(
          response => {
            if (reponse.role === 'ADMIN') {
              this.route.navigate(['/admin']);
            }
          }
        )
      }
    )
  }

}
