import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPatientDetailsComponent } from './view-patient-details.component';

describe('ViewPatientDetailsComponent', () => {
  let component: ViewPatientDetailsComponent;
  let fixture: ComponentFixture<ViewPatientDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewPatientDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPatientDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
