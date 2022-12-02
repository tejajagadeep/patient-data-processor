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
import { PatientRegistrationComponent } from './patient/registration/patient-registration/patient-registration.component';
import { ViewPatientDetailsComponent } from './patient/view/view-patient-details/view-patient-details.component';
import { HomeComponent } from './home/home.component';
import { PatientRecordsRegistrationComponent } from './patient/registration/patient-records-registration/patient-records-registration.component';
import { HttpIntercepterBasicAuthService } from './service/http/http-intercepter-basic-auth.service';
import { DoctorRegistrationComponent } from './doctor/doctor-registration/doctor-registration.component';
import { ViewPatientReportsComponent } from './patient/view/view-patient-reports/view-patient-reports.component';
import { ReportsRegistrationComponent } from './patient/registration/reports-registration/reports-registration.component';
import { BloodPressureComponent } from './charts/blood-pressure/blood-pressure.component';
import { SugarLevelComponent } from './charts/sugar-level/sugar-level.component';
import { MenuComponent } from './navbar/menu/menu.component';
import { FooterComponent } from './navbar/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ViewPatientResultsComponent } from './patient/view/view-patient-results/view-patient-results.component';
import { ResultsRegistrationComponent } from './patient/registration/results-registration/results-registration.component';
// import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

// import { MatAutocompleteModule } from '@angular/material/autocomplete';
// import { MatButtonModule } from '@angular/material/button';
// import { MatButtonToggleModule } from '@angular/material/button-toggle';
// import { MatCardModule } from '@angular/material/card';
// import { MatCheckboxModule } from '@angular/material/checkbox';
// import { MatChipsModule } from '@angular/material/chips';
// import { MatRippleModule } from '@angular/material/core';
// import { MatDividerModule } from '@angular/material/divider';
// import { MatExpansionModule } from '@angular/material/expansion';
// import { MatFormFieldModule } from '@angular/material/form-field';
// import { MatIconModule } from '@angular/material/icon';
// import { MatInputModule } from '@angular/material/input';
// import { MatListModule } from '@angular/material/list';
// import { MatMenuModule } from '@angular/material/menu';
// import { MatPaginatorModule } from '@angular/material/paginator';
// import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
// import { MatSelectModule } from '@angular/material/select';
// import { MatSidenavModule } from '@angular/material/sidenav';
// import { MatSnackBarModule } from '@angular/material/snack-bar';
// import { MatSortModule } from '@angular/material/sort';
// import { MatTableModule } from '@angular/material/table';
// import { MatTabsModule } from '@angular/material/tabs';
// import { MatToolbarModule } from '@angular/material/toolbar';
// import { MatTreeModule } from '@angular/material/tree';
// import { MatBadgeModule } from '@angular/material/badge';
// import { MatGridListModule } from '@angular/material/grid-list';
// import { MatRadioModule } from '@angular/material/radio';
// import { MatDatepickerModule } from '@angular/material/datepicker';
// import { MatTooltipModule } from '@angular/material/tooltip';
// import { OverlayModule } from '@angular/cdk/overlay';
// import { CdkTreeModule } from '@angular/cdk/tree';
// import { PortalModule } from '@angular/cdk/portal';

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
    DoctorRegistrationComponent,
    ViewPatientReportsComponent,
    ReportsRegistrationComponent,
    BloodPressureComponent,
    SugarLevelComponent,
    MenuComponent,
    FooterComponent,
    ViewPatientResultsComponent,
    ResultsRegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    BrowserAnimationsModule
    // CdkTreeModule,
    // MatAutocompleteModule,
    // MatButtonModule,
    // MatCardModule,
    // MatCheckboxModule,
    // MatChipsModule,
    // MatDividerModule,
    // MatExpansionModule,
    // MatIconModule,
    // MatInputModule,
    // MatListModule,
    // MatMenuModule,
    // MatProgressSpinnerModule,
    // MatPaginatorModule,
    // MatRippleModule,
    // MatSelectModule,
    // MatSidenavModule,
    // MatSnackBarModule,
    // MatSortModule,
    // MatTableModule,
    // MatTabsModule,
    // MatToolbarModule,
    // MatFormFieldModule,
    // MatButtonToggleModule,
    // MatTreeModule,
    // OverlayModule,
    // PortalModule,
    // MatBadgeModule,
    // MatGridListModule,
    // MatRadioModule,
    // MatDatepickerModule,
    // MatTooltipModule,

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpIntercepterBasicAuthService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
  // schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
