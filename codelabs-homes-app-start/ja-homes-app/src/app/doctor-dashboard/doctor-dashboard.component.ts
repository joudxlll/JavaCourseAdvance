import { Component } from '@angular/core';
import {RouterLink, RouterModule, RouterOutlet} from "@angular/router";
import {ScheduleComponent} from "../schedule/schedule.component";

@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink,
  ],
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorDashboardComponent {

}
