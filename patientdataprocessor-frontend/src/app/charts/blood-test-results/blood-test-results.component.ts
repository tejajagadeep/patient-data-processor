import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ResultsDataService } from 'src/app/service/data/results-data.service';
import { Location } from '@angular/common';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-blood-test-results',
  templateUrl: './blood-test-results.component.html',
  styleUrls: ['./blood-test-results.component.css']
})
export class BloodTestResultsComponent implements OnInit {

  contactNumber!: number

  constructor(
    private patientService: ResultsDataService,
    private location: Location,
    private route: ActivatedRoute
  ) { }
  chartdata: any;
  labeldata: any[] = [];
  realdata1: any[] = [];
  realdata2: any[] = [];
  realdata3: any[] = [];
  realdata4: any[] = [];
  realdata5: any[] = [];
  realdata6: any[] = [];
  realdata7: any[] = [];
  realdata8: any[] = [];
  navBack() {
    this.location.back();
  }

  ngOnInit(): void {
    this.contactNumber = this.route.snapshot.params['contactNumber']
    this.patientService.getChartInfo(this.contactNumber).subscribe((result) => {
      this.chartdata = result;
      if (this.chartdata != null) {
        for (let i = 0; i < this.chartdata.length; i++) {
          console.log(this.chartdata[i]);
          this.labeldata.push(this.chartdata[i].date);
          this.realdata1.push(this.chartdata[i].whiteBloodCells);
          this.realdata2.push(this.chartdata[i].redBloodCells);
          this.realdata3.push(this.chartdata[i].hemoglobin);
          this.realdata4.push(this.chartdata[i].hemotocrit);
          this.realdata5.push(this.chartdata[i].meanCellVolume);
          this.realdata6.push(this.chartdata[i].meanCellHemoglobin);
          this.realdata7.push(this.chartdata[i].platelets);
          this.realdata8.push(this.chartdata[i].reticulocyte);
          // this.realdata2.push(this.chartdata[i].diastolic);
          // this.colordata.push(this.chartdata[i].colorcode);
        }
        // this.RenderChart(this.labeldata, this.realdata, this.colordata, 'bar', 'barchart');
        this.RenderChart(this.labeldata, this.realdata1, this.realdata2, this.realdata3, this.realdata4, this.realdata5, this.realdata6, this.realdata7, this.realdata8);
      }
    });
  }
  RenderChart(labeldata: any, realdata1: any, realdata2: any, realdata3: any, realdata4: any, realdata5: any, realdata6: any, realdata7: any, realdata8: any) {
    const myChart = new Chart("linechart", {
      type: "line",
      data: {
        labels: labeldata,
        datasets: [{
          label: 'White Blood Cells',
          data: realdata1,
          //if for threshold color red
          backgroundColor: '#808080',
          // borderColor: '#05445E',
          borderColor: '#808080',
          borderWidth: 1
        },
        {
          label: 'Red Blood Cells',
          data: realdata2,
          backgroundColor: '#FF7F00',
          borderColor: '#FF7F00',
          borderWidth: 1
        },
        {
          label: 'Hemoglobin',
          data: realdata3,
          backgroundColor: '#0000CC',
          borderColor: '#0000CC',
          borderWidth: 1
        },
        {
          label: 'Hemotocrit',
          data: realdata4,
          backgroundColor: '#CC0099',
          borderColor: '#CC0099',
          borderWidth: 1
        },
        {
          label: 'Mean Cell Volume',
          data: realdata5,
          backgroundColor: '#996600',
          borderColor: '#996600',
          borderWidth: 1
        },
        {
          label: 'Mean Cell Hemoglobin',
          data: realdata6,
          backgroundColor: '#A52A2A',
          borderColor: '#A52A2A',
          borderWidth: 1
        },
        {
          label: 'Platelets',
          data: realdata7,
          backgroundColor: '#006666',
          borderColor: '#006666',
          borderWidth: 1
        },
        {
          label: 'Reticulocyte',
          data: realdata8,
          backgroundColor: '#000000',
          borderColor: '#000000',
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
