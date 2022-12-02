import { TestBed } from '@angular/core/testing';

import { ResultsDataServiceService } from './results-data-service.service';

describe('ResultsDataServiceService', () => {
  let service: ResultsDataServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResultsDataServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
