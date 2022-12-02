import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportsRegistrationComponent } from './reports-registration.component';

describe('ReportsRegistrationComponent', () => {
  let component: ReportsRegistrationComponent;
  let fixture: ComponentFixture<ReportsRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportsRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportsRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
