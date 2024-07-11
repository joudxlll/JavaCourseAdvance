import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientSignComponent } from './patient-sign.component';

describe('SignupComponent', () => {
  let component: PatientSignComponent;
  let fixture: ComponentFixture<PatientSignComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PatientSignComponent]
    });
    fixture = TestBed.createComponent(PatientSignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
