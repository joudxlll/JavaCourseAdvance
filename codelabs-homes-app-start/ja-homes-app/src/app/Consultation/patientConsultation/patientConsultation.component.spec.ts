import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientConsultationComponent } from './patientConsultation.component';

describe('ConsultationComponent', () => {
  let component: PatientConsultationComponent;
  let fixture: ComponentFixture<PatientConsultationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PatientConsultationComponent]
    });
    fixture = TestBed.createComponent(PatientConsultationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
