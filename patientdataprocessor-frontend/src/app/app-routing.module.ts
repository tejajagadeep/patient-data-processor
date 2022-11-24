import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { AdminDashboardComponent } from './component/admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './component/user-dashboard/user-dashboard.component';
import { AuthguardService } from './service/auth.guard';
import { AuthGuardService } from './service/auth/auth-guard.service';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path:'login', component: LoginComponent},
  {path:'signup', component: SignupComponent},
  {path: 'user', component: UserDashboardComponent,canActivate:[AuthGuardService]},
  {path: 'admin', component:AdminDashboardComponent,canActivate:[AuthGuardService]},
  { path: '**', component: LoginComponent, canActivate: [AuthGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
