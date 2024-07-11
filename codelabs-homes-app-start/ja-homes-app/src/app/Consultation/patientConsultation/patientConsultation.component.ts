import { Component } from '@angular/core';
import { NgForOf, NgIf } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { ConsultationService } from "../../../../services/consultation.service";

@Component({
    selector: 'app-consultation',
    templateUrl: './patientConsultation.component.html',
    imports: [
        NgIf,
        NgForOf,
        FormsModule
    ],
    standalone: true,
    styleUrls: ['./patientConsultation.component.css']
})
export class PatientConsultationComponent {
    consultationId: number = 0; // Initialize with default value
    consultation: any; // Object to hold consultation details

    insertConsultation = {
        doctor_id: 0,
        patient_id: 0,
    };

    updateConsultationRate = {
        consultation_id: 0,
        consultation_rate: 0
    };

    showSearchSection: boolean = false;
    showAddSection: boolean = false;
    showUpdateSection: boolean = false;

    constructor(private consultationService: ConsultationService) {}

    toggleSection(section: string): void {
        // Reset all section flags
        this.showSearchSection = false;
        this.showAddSection = false;
        this.showUpdateSection = false;

        // Toggle the selected section
        switch (section) {
            case 'search':
                this.showSearchSection = true;
                break;
            case 'add':
                this.showAddSection = true;
                break;
            case 'update':
                this.showUpdateSection = true;
                break;
            default:
                break;
        }
    }

    searchConsultation() {
        this.consultationService.getConsultationById(this.consultationId).subscribe(
            (response) => {
                this.consultation = response;
                console.log('Consultation Details:', this.consultation);
            }
        );
    }

    onSubmitInsert(): void {
        this.consultationService.insertConsultation(this.insertConsultation)
            .subscribe(response => {
                console.log('Consultation added successfully:', response);
            });
    }

    onSubmitUpdateRate(): void {
        this.consultationService.updateConsultationRate(this.updateConsultationRate.consultation_id, this.updateConsultationRate)
            .subscribe(response => {
                console.log('Consultation Updated successfully:', response);
            });
    }

    isDataEmpty(): boolean {
        return !this.consultation || this.consultation.length === 0;
    }
}
