import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {​​​​​​ Chart, registerables }​​​​​​ from 'chart.js';
import { Patient } from 'src/app/model/patient';
import { PatientDataService } from 'src/app/service/data/patient-data.service';

Chart.register(...registerables);

@Component({
  selector: 'app-sugar-level',
  templateUrl: './sugar-level.component.html',
  styleUrls: ['./sugar-level.component.css']
})
export class SugarLevelComponent implements OnInit {

  contactNumber!: number

  constructor(
    private patientService: PatientDataService,
    private route: ActivatedRoute
    ) { }
  chartdata: any;
  labeldata: any[] = [];
  realdata: any[] = [];
  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.patientService.getChartInfo(this.contactNumber).subscribe((result) => {
      this.chartdata = result;
      if (this.chartdata != null) {
        for (let i = 0; i < this.chartdata.length; i++) {
          console.log(this.chartdata[i]);
          this.labeldata.push(this.chartdata[i].date);
          this.realdata.push(this.chartdata[i].sugarlevel);
          // this.realdata2.push(this.chartdata[i].diastolic);
          // this.colordata.push(this.chartdata[i].colorcode);
        }
        // this.RenderChart(this.labeldata, this.realdata, this.colordata, 'bar', 'barchart');
        this.RenderChart(this.labeldata, this.realdata);
      }
    });
  }
  RenderChart(labeldata: any, realdata: any) {
    const myChart = new Chart("linechart", {
      type: "line",
      data: {
        labels: labeldata,
        datasets: [{
          label: 'Sugar Level',
          data: realdata,
          backgroundColor: '#3202C5',
          // borderColor: '#05445E',
          borderColor: '#3202C5',
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

}
