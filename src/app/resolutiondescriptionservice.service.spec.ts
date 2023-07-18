import { TestBed } from '@angular/core/testing';

import { ResolutiondescriptionserviceService } from './resolutiondescriptionservice.service';

describe('ResolutiondescriptionserviceService', () => {
  let service: ResolutiondescriptionserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResolutiondescriptionserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
