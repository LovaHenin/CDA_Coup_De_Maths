import { TestBed } from '@angular/core/testing';

import { ResponseService } from './services/response.service';

describe('ResponseService', () => {
  let service: ResponseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResponseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
