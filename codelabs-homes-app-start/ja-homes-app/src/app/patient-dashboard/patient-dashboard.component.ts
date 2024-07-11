import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-patient-dashboard',
  templateUrl: './patient-dashboard.component.html',
  standalone: true,
  imports: [
    RouterLink,
    RouterOutlet
  ],
  styleUrls: ['./patient-dashboard.component.css']
})
export class PatientDashboardComponent {

}
