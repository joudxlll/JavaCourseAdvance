import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Doctor} from "../doctor";
import {SigninService} from "../../../services/signin.service";
import {SignIn} from "../sign-in";
import {Router} from "@angular/router";
import {DoctorService} from "../../../services/doctor.service";

@Component({
  selector: 'app-signin',
  templateUrl: './doctor-sign.component.html',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  styleUrls: ['./doctor-sign.component.css']
})
export class DoctorSignComponent {
  // protected data: any[] | undefined;
  //
  // signIn: SignIn = {
  //   doctor_email: '',
  //   doctor_password: ''
  // };
  // constructor(private signinService: SigninService) {
  // }
  //
  // onSubmit(): void {
  //   this.signinService.signIn(this.signIn).subscribe(doctor =>
  //   {
  //     this.data = doctor;
  //
  //   });
  // }
  loginObject: Login;

  Doctor = {
    doctor_name: '',
    doctor_email: '',
    doctor_phone: 0,
    doctor_specialty: '',
    doctor_password: ''
  };

  constructor(private router: Router, private doctorService: DoctorService) {
    this.loginObject =new Login();
  }

  onLogin(): void{
    if(this.loginObject.username === 'admin' && this.loginObject.password === 'admin'){
      alert('Login Successful');
      this.router.navigateByUrl('doctorDashboard')
    }else {
      alert('Invalid username or password');

    }
  }


  onSubmit(): void {
    debugger
    this.doctorService.insertDoctor(this.Doctor)
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
