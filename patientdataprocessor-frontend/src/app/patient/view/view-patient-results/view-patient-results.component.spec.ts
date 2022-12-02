import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPatientResultsComponent } from './view-patient-results.component';

describe('ViewPatientResultsComponent', () => {
  let component: ViewPatientResultsComponent;
  let fixture: ComponentFixture<ViewPatientResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPatientResultsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPatientResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
