import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodTestResultsComponent } from './blood-test-results.component';

describe('BloodTestResultsComponent', () => {
  let component: BloodTestResultsComponent;
  let fixture: ComponentFixture<BloodTestResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodTestResultsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BloodTestResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
