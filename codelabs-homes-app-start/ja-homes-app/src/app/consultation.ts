export interface Consultation {
    consultation_id?: number; // Optional if you don't include this in the insert operation
    doctor_id: number;
    patient_id: number;
}
