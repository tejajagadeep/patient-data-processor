import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { LogoutComponent } from './auth/logout/logout.component';
import { SignupComponent } from './auth/signup/signup.component';
import { AdminDashboardComponent } from './component/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './component/user-dashboard/user-dashboard.component';
import { DoctorRegistrationComponent } from './doctor/doctor-registration/doctor-registration.component';
import { HomeComponent } from './home/home.component';
import { PatientRecordsRegistrationComponent } from './patient/patient-records-registration/patient-records-registration.component';
import { PatientRegistrationComponent } from './patient/patient-registration/patient-registration.component';
import { ViewPatientDetailsComponent } from './patient/view-patient-details/view-patient-details.component';
import { AuthGuardService } from './service/auth/auth-guard.service';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardService] },
  { path: 'patient-registration', component: PatientRegistrationComponent, canActivate: [AuthGuardService]  },
  { path: 'patient-records-registration/:contactNumber', component: PatientRecordsRegistrationComponent, canActivate: [AuthGuardService]  },
  { path: 'doctor-registration', component: DoctorRegistrationComponent, canActivate: [AuthGuardService]  },
  { path: 'view-patient-details/:contactNumber', component: ViewPatientDetailsComponent, canActivate: [AuthGuardService]  },
  { path: 'user-dashboard', component: UserDashboardComponent, canActivate: [AuthGuardService]  },

  { path: 'doctor', component: UserDashboardComponent, canActivate: [AuthGuardService] },
  { path: 'admin', component: AdminDashboardComponent, canActivate: [AuthGuardService] },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGuardService] },
  { path: '**', component: LoginComponent, canActivate: [AuthGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
