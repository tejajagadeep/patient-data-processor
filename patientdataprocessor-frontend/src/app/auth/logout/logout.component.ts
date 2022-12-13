import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageResponse } from 'src/app/model/message-response';
import { User } from 'src/app/model/user';
import { AuthenticationDataService } from 'src/app/service/auth/authentication-data.service';
import { UserDataService } from 'src/app/service/data/user-data.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  username=''
  password=''
  errorMessage='Successfully Logged Out'
  successMessage!: string
  invalidLogin = false
  isLogin = false
  user!: User
  messageResponse!: MessageResponse

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private authenticateLoginService: AuthenticationDataService,
    private userService: UserDataService
  ) { }

  ngOnInit(): void {
    this.authenticateLoginService.logOut()
    console.log('login.component.ts')
    // this.password = 'ABCabc@123'
    this.isLogin = this.authenticateLoginService.isUserLoggedIn();
    console.log(this.isLogin)
  }

  navLink() {
    console.log('navLink')
    this.router.navigate(["home"]);
  }




  handleSuccessResponse(response: any) {
    // console.log(response);
    this.successMessage = response.message
  }

  handleErrorResponse(error: any) {
    // console.log(response);
    this.errorMessage = error.error.message
  }



  checkLogin1() {
    if(this.username===''){
      this.errorMessage = "Email Address is Required"
    } 
    else if(this.password===''){
      this.errorMessage = "Password is Required"
    } else {
    this.authenticateLoginService.authenticate(this.username, this.password).subscribe(
      response => {
        this.user = response,
          this.router.navigate(['home'])
      },
      error => {
        this.errorMessage = "Invalid Credentials"
      }

    );
    }
    //   this.userService.getUserByUserName(this.username).subscribe(
    //     resp => {
    //         console.log(resp.role)
    //         if( resp.role == 'AMDIN'){
    //         this.router.navigate(['admin'])
    //       }
    //       if(resp.role == 'DOCTOR'){
    //         this.router.navigate(['doctor'])
    //       }
    // }
    //   )
  }


}
