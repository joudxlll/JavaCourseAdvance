import { Component } from '@angular/core';
import {MedicalRecordsService} from "../../../services/medical-records.service";
import {FormsModule} from "@angular/forms";
import {DatePipe, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-medical-report',
  templateUrl: './medical-report.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    NgForOf,
    DatePipe
  ],
  styleUrls: ['./medical-report.component.css']
})
export class MedicalReportComponent {
  patient_id: number = 0;
  medicalReports: any[] = [];
  // protected data: any[] | undefined;

  constructor(private medicalRecordsService: MedicalRecordsService) {}

  // ngOnInit(){
  //   this.medicalRecordsService.getAllMedicalReports(3).subscribe(doctors => {
  //     this.data = doctors;
  //     console.log(this.data)})
  // }

  searchMedicalRecords() {
    this.medicalRecordsService.getAllMedicalReports(this.patient_id).subscribe(
        (response) => {
          this.medicalReports = response;
          console.log('Medical Reports:', this.medicalReports);
        }
    );}
}
