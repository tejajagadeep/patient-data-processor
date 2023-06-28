import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultsRegistrationComponent } from './results-registration.component';

describe('ResultsRegistrationComponent', () => {
  let component: ResultsRegistrationComponent;
  let fixture: ComponentFixture<ResultsRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResultsRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultsRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
