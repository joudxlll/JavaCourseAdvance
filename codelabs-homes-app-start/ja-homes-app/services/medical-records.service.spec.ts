import { TestBed } from '@angular/core/testing';

import { MedicalRecordsService } from './medical-records.service';

describe('MedicalRecordsService', () => {
  let service: MedicalRecordsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicalRecordsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
