import { TestBed } from '@angular/core/testing';

import { ReportsDataService } from './reports-data.service';

describe('ReportsDataService', () => {
  let service: ReportsDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReportsDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
