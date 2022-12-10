import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { LogoutComponent } from './auth/logout/logout.component';
import { SignupComponent } from './auth/signup/signup.component';
import { BloodPressureComponent } from './charts/blood-pressure/blood-pressure.component';
import { BloodTestResultsComponent } from './charts/blood-test-results/blood-test-results.component';
import { SugarLevelComponent } from './charts/sugar-level/sugar-level.component';
import { AdminDashboardComponent } from './component/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './component/user-dashboard/user-dashboard.component';
import { DoctorRegistrationComponent } from './doctor/doctor-registration/doctor-registration.component';
import { HomeComponent } from './home/home.component';
import { PatientRecordsRegistrationComponent } from './patient/registration/patient-records-registration/patient-records-registration.component';
import { PatientRegistrationComponent } from './patient/registration/patient-registration/patient-registration.component';
import { ReportsRegistrationComponent } from './patient/registration/reports-registration/reports-registration.component';
import { ResultsRegistrationComponent } from './patient/registration/results-registration/results-registration.component';
import { ViewPatientDetailsComponent } from './patient/view/view-patient-details/view-patient-details.component';
import { ViewPatientReportsComponent } from './patient/view/view-patient-reports/view-patient-reports.component';
import { ViewPatientResultsComponent } from './patient/view/view-patient-results/view-patient-results.component';
import { AuthGuardService } from './service/auth/auth-guard.service';
import { DoctorAuthGuardService } from './service/role/doctor-auth-guard.service';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent, canActivate: [AuthGuardService] },
  { path: 'patient-registration', component: PatientRegistrationComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']} },
  { path: 'patient-records-registration/:contactNumber', component: PatientRecordsRegistrationComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']}  },
  { path: 'reports-registration/:contactNumber', component: ReportsRegistrationComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']}  },
  { path: 'results-registration/:contactNumber', component: ResultsRegistrationComponent, canActivate: [DoctorAuthGuardService] , data: {roles:['DOCTOR']} },
  { path: 'doctor-registration', component: DoctorRegistrationComponent, canActivate: [DoctorAuthGuardService], data: {roles:['ADMIN']}   },
  { path: 'view-patient-details/:contactNumber', component: ViewPatientDetailsComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']}  },
  { path: 'view-patient-results/:contactNumber', component: ViewPatientResultsComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']}  },
  { path: 'view-patient-reports/:contactNumber', component: ViewPatientReportsComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']}  },

  { path: 'charts-bp/:contactNumber', component: BloodPressureComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']}  },
  { path: 'charts-sugar/:contactNumber', component: SugarLevelComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']}  },
  { path: 'charts-blood-test-results/:contactNumber', component: BloodTestResultsComponent, canActivate: [DoctorAuthGuardService], data: {roles:['DOCTOR']}  },
  { path: 'logout', component: LogoutComponent, canActivate: [AuthGuardService] },
  { path: '**', component: LoginComponent, canActivate: [AuthGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
