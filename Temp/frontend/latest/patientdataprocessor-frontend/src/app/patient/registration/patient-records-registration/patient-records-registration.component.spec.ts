import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientRecordsRegistrationComponent } from './patient-records-registration.component';

describe('PatientRecordsRegistrationComponent', () => {
  let component: PatientRecordsRegistrationComponent;
  let fixture: ComponentFixture<PatientRecordsRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientRecordsRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientRecordsRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
