import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPatientReportsComponent } from './view-patient-reports.component';

describe('ViewPatientReportsComponent', () => {
  let component: ViewPatientReportsComponent;
  let fixture: ComponentFixture<ViewPatientReportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPatientReportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPatientReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
