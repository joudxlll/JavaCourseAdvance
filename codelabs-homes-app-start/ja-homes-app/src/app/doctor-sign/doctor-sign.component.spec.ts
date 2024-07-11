import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorSignComponent } from './doctor-sign.component';

describe('SigninComponent', () => {
  let component: DoctorSignComponent;
  let fixture: ComponentFixture<DoctorSignComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DoctorSignComponent]
    });
    fixture = TestBed.createComponent(DoctorSignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
