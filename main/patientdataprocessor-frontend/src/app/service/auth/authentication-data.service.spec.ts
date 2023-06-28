import { TestBed } from '@angular/core/testing';

import { AuthenticationDataService } from './authentication-data.service';

describe('AuthenticationDataService', () => {
  let service: AuthenticationDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticationDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
