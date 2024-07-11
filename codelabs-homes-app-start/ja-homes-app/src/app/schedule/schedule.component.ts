import { Component } from '@angular/core';
import {ScheduleService} from "../../../services/schedule.service";
import {NgIf} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  standalone: true,
  imports: [
    NgIf,
    FormsModule,
    ReactiveFormsModule
  ],
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent {

  schedule: any; // Adjust the type according to your response structure
  docId: number = 0; // Example doctor ID, you'll likely fetch this dynamically

  insertSchedule = {
    doctor_id: 0,
    schedule_startTime: '',
    schedule_endTime: '',
    isAvailable: false,
  };

  updateSchedule = {
    schedule_id: 0,
    isAvailable: false,
  };

  constructor(private scheduleService: ScheduleService) { }

  // ngOnInit(): void {
  //   this.getDoctorSchedule(this.docId);
  // }

  onSubmitSearch(): void {
    this.scheduleService.getScheduleByDoctorId(this.docId).subscribe(
        (data) => {
          this.schedule = data;
          console.log('Schedule:', this.schedule);
          console.log('isAvailable:', this.schedule.isAvailable);
        }
    );
  }


  onSubmit(): void {
    this.scheduleService.insertSchedule(this.insertSchedule)
        .subscribe(response => {
          console.log('Consultation added successfully:', response);
        });
  }

  onSubmitUpdate(): void {
    this.scheduleService.updateSchedule(this.updateSchedule.schedule_id,this.updateSchedule)
        .subscribe(response => {
          console.log('Consultation added successfully:', response);
        });
  }


}
