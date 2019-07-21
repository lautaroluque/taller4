import { TestBed } from '@angular/core/testing';

import { LogininterceptorService } from './logininterceptor.service';

describe('LogininterceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LogininterceptorService = TestBed.get(LogininterceptorService);
    expect(service).toBeTruthy();
  });
});
