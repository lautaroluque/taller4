import { TestBed } from '@angular/core/testing';

import { LoginInterceptorService } from './logininterceptor.service';

describe('LoginInterceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginInterceptorService = TestBed.get(LoginInterceptorService);
    expect(service).toBeTruthy();
  });
});
