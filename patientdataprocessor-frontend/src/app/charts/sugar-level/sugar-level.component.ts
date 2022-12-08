import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Chart, registerables } from 'chart.js';
import { Patient } from 'src/app/model/patient';
import { PatientDataService } from 'src/app/service/data/patient-data.service';
import { Location } from '@angular/common';
import { ReportsDataService } from 'src/app/service/data/reports-data.service';

Chart.register(...registerables);

@Component({
  selector: 'app-sugar-level',
  templateUrl: './sugar-level.component.html',
  styleUrls: ['./sugar-level.component.css']
})
export class SugarLevelComponent implements OnInit {

  contactNumber!: number
  patient!: Patient

  constructor(
    private patientService: PatientDataService,
    private reportService: ReportsDataService,
    private location: Location,
    private route: ActivatedRoute
  ) { }
  chartdata: any;
  labeldata: any[] = [];
  realdata1: any[] = [];
  realdata2: any[] = [];
  navBack() {
    this.location.back();
  }

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.getPatient(this.contactNumber)

    this.reportService.getChartInfo(this.contactNumber).subscribe((result) => {
      this.chartdata = result;
      if (this.chartdata != null) {
        for (let i = 0; i < this.chartdata.length; i++) {
          console.log(this.chartdata[i]);
          this.labeldata.push(this.chartdata[i].date);
          this.realdata1.push(this.chartdata[i].sugarlevel);
          this.realdata2.push(this.chartdata[i].sugarlevel2);
          // this.realdata2.push(this.chartdata[i].diastolic);
          // this.colordata.push(this.chartdata[i].colorcode);
        }
        // this.RenderChart(this.labeldata, this.realdata, this.colordata, 'bar', 'barchart');
        this.RenderChart(this.labeldata, this.realdata1, this.realdata2);
      }
    });
  }
  RenderChart(labeldata: any, realdata1: any, realdata2: any) {
    const myChart = new Chart("linechart", {
      type: "line",
      data: {
        labels: labeldata,
        datasets: [{
          label: 'Fasting Blood Sugar',
          data: realdata1,
          backgroundColor: '#3202C5',
          // borderColor: '#05445E',
          borderColor: '#3202C5',
          borderWidth: 1
        },
        {
          label: 'Postprandial Blood Sugar',
          data: realdata2,
          backgroundColor: '#FF7F00',
          borderColor: '#FF7F00',
          borderWidth: 1
        }]
      },

      /* options: {
        scales: {
          y: {
            // beginAtZero: false
          }
        }
      } */
    });
  }

  getPatient(contactNumber1: number) {
    this.patientService.getByContactNumber(contactNumber1).subscribe(
      response => this.patient = response
    )
  }
}
