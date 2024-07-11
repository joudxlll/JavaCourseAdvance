import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {ConsultationService} from "../../../../services/consultation.service";

@Component({
  selector: 'app-doctor-consultation',
  templateUrl: './doctor-consultation.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    ReactiveFormsModule
  ],
  styleUrls: ['./doctor-consultation.component.css']
})
export class DoctorConsultationComponent {
  filter: any = {};
  data: any[] | undefined;

  updateConsultation = {
    consultation_id:0,
    consultation_status: '',
    consultation_diagnosis: '',
  };



  constructor(private consultationService: ConsultationService) {
  }


  onSearch() {
    this.consultationService.getPendingConsultation(this.filter).subscribe(
        (consultation) => {
          this.data = consultation;
          console.log(this.data);
        }
    );
  }

  isDataEmpty(): boolean {
    return !this.data || this.data.length === 0;
  }

  onSubmitUpdate(): void {
    this.consultationService.updateConsultation(this.updateConsultation.consultation_id, this.updateConsultation)
        .subscribe(response => {
          console.log('Consultation Updated successfully:', response);
        });
  }
}
