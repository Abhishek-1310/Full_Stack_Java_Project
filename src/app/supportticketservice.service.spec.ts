import { TestBed } from '@angular/core/testing';

import { SupportticketserviceService } from './supportticketservice.service';

describe('SupportticketserviceService', () => {
  let service: SupportticketserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupportticketserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
