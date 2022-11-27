import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  name : string = '';
  username : string = '';
  password : string = '';

  user : User = new User();

  constructor( 
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserDataService,
    private authService: AuthenticationDataService
  ) { }

  ngOnInit(): void {
    this.username = '';
    this.password = '';
    this.name = '';
  }

  login(){
    this.authService.authenticate(this.username, this.password).subscribe(
      response => {}
    )
  }

  // signup() {

  //   // this.user.username = this.username;
  //   this.user.password = this.password;
  //   this.user.name = this.name;
  //   this.user.role = 'user';

  //   this.authService.signUp(this.user).subscribe(res => {
  //     if(res == null) {
  //       alert("Registration failed");
  //       this.ngOnInit();
  //     }else {
  //       console.log("Registration successful");
  //       alert("Registration successful");
  //       this.route.navigate(['/']);
  //     }
  //   }, err => {
  //     alert("Registration failed.");
  //     this.ngOnInit();
  //   })

  // }

}