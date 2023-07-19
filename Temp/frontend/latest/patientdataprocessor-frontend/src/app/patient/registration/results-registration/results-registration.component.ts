import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/model/patient';
import { Results } from 'src/app/model/results';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { ResultsDataService } from 'src/app/service/data/results-data.service';
import { Location } from '@angular/common';
// import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-results-registration',
  templateUrl: './results-registration.component.html',
  styleUrls: ['./results-registration.component.css'],
})
export class ResultsRegistrationComponent implements OnInit {
  results!: Results;
  errorMessageResponse!: string;
  dummyNumber!: number;
  patient!: Patient;
  contactNumber!: number;
  dummyDate!: DateConstructor;

  whiteBloodCellsT = false;
  redBloodCellsT = false;
  hemoglobinT = false;
  hemotocritT = false;
  meanCellVolumeT = false;
  meanCellHemoglobinT = false;
  plateletsT = false;
  reticulocyteT = false;

  constructor(
    private resultsService: ResultsDataService,
    private patientService: PatientDataService,
    private router: Router,
    private location: Location,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber'];
    this.results = new Results(
      this.dummyNumber,
      this.dummyNumber,
      this.dummyNumber,
      this.dummyNumber,
      this.dummyNumber,
      this.dummyNumber,
      this.dummyNumber,
      this.dummyNumber,
      this.dummyNumber,
      this.dummyNumber,
      this.dummyDate
    );
    this.getPatient(this.contactNumber);
  }
  OnlyNumbers(event: any): boolean {
    const charCode = event.which ? event.which : event.keyCode;

    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }

    return true;
  }
  getPatient(contactNumber1: number) {
    this.patientService
      .getByContactNumber(contactNumber1)
      .subscribe((response) => (this.patient = response));
  }
  saveResults() {
    if (this.results.whiteBloodCells === this.dummyNumber) {
      this.whiteBloodCellsT = true;
    }
    if (this.results.redBloodCells === this.dummyNumber) {
      this.redBloodCellsT = true;
    }
    if (this.results.hemoglobin === this.dummyNumber) {
      this.hemoglobinT = true;
    }
    if (this.results.hemotocrit === this.dummyNumber) {
      this.hemotocritT = true;
    }
    if (this.results.meanCellVolume === this.dummyNumber) {
      this.meanCellVolumeT = true;
    }
    if (this.results.meanCellHemoglobin === this.dummyNumber) {
      this.meanCellHemoglobinT = true;
    }
    if (this.results.platelets === this.dummyNumber) {
      this.plateletsT = true;
    }
    if (this.results.reticulocyte === this.dummyNumber) {
      this.reticulocyteT = true;
    }

    if (
      this.results.whiteBloodCells !== this.dummyNumber &&
      this.results.redBloodCells !== this.dummyNumber &&
      this.results.hemoglobin !== this.dummyNumber &&
      this.results.hemotocrit !== this.dummyNumber &&
      this.results.meanCellVolume !== this.dummyNumber &&
      this.results.meanCellHemoglobin !== this.dummyNumber &&
      this.results.platelets !== this.dummyNumber &&
      this.results.reticulocyte !== this.dummyNumber
    ) {
      this.results.contactNumber = this.contactNumber;
      this.resultsService.saveResults(this.results).subscribe(
        (repsonse) => {
          console.log(repsonse);
          // repsonse.day = new Date()
          this.router.navigate(['view-patient-results', this.contactNumber]);
        },
        (error) => (this.errorMessageResponse = error.error.message)
      );
    }
  }

  navBack() {
    this.location.back();
  }
}
