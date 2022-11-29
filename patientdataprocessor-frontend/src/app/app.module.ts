import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { UserDashboardComponent } from './component/user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './component/admin-dashboard/admin-dashboard.component';
import { HttpIntercepterService } from './service/auth/http-intercepter.service';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { LogoutComponent } from './auth/logout/logout.component';
import { PatientRegistrationComponent } from './patient/patient-registration/patient-registration.component';
import { ViewPatientDetailsComponent } from './patient/view-patient-details/view-patient-details.component';
import { HomeComponent } from './home/home.component';
import { PatientRecordsRegistrationComponent } from './patient/patient-records-registration/patient-records-registration.component';
import { HttpIntercepterBasicAuthService } from './service/http/http-intercepter-basic-auth.service';
import { DoctorRegistrationComponent } from './doctor/doctor-registration/doctor-registration.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    LogoutComponent,
    PatientRegistrationComponent,
    ViewPatientDetailsComponent,
    HomeComponent,
    PatientRecordsRegistrationComponent,
    DoctorRegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpIntercepterBasicAuthService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
