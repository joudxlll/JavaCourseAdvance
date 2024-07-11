import { Component } from '@angular/core';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Router} from "@angular/router";
import {PatientService} from "../../../services/patient.service";

@Component({
  selector: 'app-signup',
  templateUrl: './patient-sign.component.html',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  styleUrls: ['./patient-sign.component.css']
})
export class PatientSignComponent {
  loginObject: Login;

  Patient = {
    patient_name: '',
    patient_email: '',
    patient_password: '',
    patient_phone: 0,
    patient_dateOfBirth: ''
  };

  constructor(private router: Router, private patientService: PatientService) {
    this.loginObject =new Login();
  }

  onLogin(): void{
    if(this.loginObject.username === 'admin' && this.loginObject.password === 'admin'){
      alert('Login Successful');
      this.router.navigateByUrl('patientDashboard')
    }else {
      alert('Invalid username or password');

    }
  }


  onSubmit(): void {
    debugger
    this.patientService.insertPatient(this.Patient)
        .subscribe(response => {
          console.log('Doctor added successfully:', response);
        });
  }
}
export class Login{
  username: string;
  password: string;

  constructor() {
    this.username = '';
    this.password = '';


  }

}
