import { Component } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {observable} from "rxjs";
import {JsonPipe, NgForOf, NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {DoctorComponent} from "./doctor/doctor.component";
import {PatientConsultationComponent} from "./Consultation/patientConsultation/patientConsultation.component";
import {MedicalReportComponent} from "./medical-report/medical-report.component";
import {ScheduleComponent} from "./schedule/schedule.component";
import {RouterModule} from "@angular/router";
import { Router } from '@angular/router';

@Component({
  standalone: true,
  imports: [HttpClientModule, JsonPipe, NgIf, NgForOf, FormsModule, DoctorComponent, PatientConsultationComponent, MedicalReportComponent, ScheduleComponent,RouterModule],
  selector: 'app-root',
  template: `
    <header>
      <div class="logo-container">
        <img src="../assets/SDAIA.png" alt="Website Logo">
      </div>
    </header>
    <button class="back-btn" (click)="goBack()">Back</button>

    <div class="container" *ngIf="showRole">

      <div class="role-options-container">
        <div class="role-option patient">
          <a routerLink="signPatient" (click)="selectRole('patient')">
            <div class="option">
              <img src="../assets/patientLogo.png" alt="Patient">
              <p>Patient</p>
            </div>
          </a>
        </div>

        <div class="role-option doctor" >
          <a routerLink="signDoctor" (click)="selectRole('doctor')">
            <div class="option">
              <img src="../assets/doctorLogo.png" alt="Doctor" class="doctor-logo">
              <p style=" margin-top: 30px;">Doctor</p>
            </div>
          </a>
        </div>
      </div>
      
    </div>
<header>

  <main>
    <router-outlet></router-outlet>
  </main>
</header>

  
  `,
  styleUrls: ['./app.component.css'],
})
export class AppComponent { //i can write this in doctor component / patient /....
  showMenu: boolean = false;
  showRole: boolean = true;

  constructor(private router: Router) {}

  selectRole(role: string) {
    console.log('Selected role:', role);
    // Hide the menu
    this.showRole = false;
  }

  goBack() {
    this.router.navigate(['/']); // Navigate to the previous route
    this.showRole = true;

  }

}


