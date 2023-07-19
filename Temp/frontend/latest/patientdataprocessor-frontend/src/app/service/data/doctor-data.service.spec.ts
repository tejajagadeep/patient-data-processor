import { TestBed } from '@angular/core/testing';

import { DoctorDataService } from './doctor-data.service';

describe('DoctorDataService', () => {
  let service: DoctorDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoctorDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
