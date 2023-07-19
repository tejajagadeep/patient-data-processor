import { TestBed } from '@angular/core/testing';

import { ResultsDataService } from './results-data.service';

describe('ResultsDataService', () => {
  let service: ResultsDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResultsDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
