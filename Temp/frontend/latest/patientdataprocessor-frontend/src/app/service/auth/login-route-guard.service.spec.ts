import { TestBed } from '@angular/core/testing';

import { LoginRouteGuardService } from './login-route-guard.service';

describe('LoginRouteGuardService', () => {
  let service: LoginRouteGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginRouteGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
