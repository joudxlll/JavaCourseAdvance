export interface Doctor {
    doctor_id?: number; // Optional if you don't include this in the insert operation
    doctor_name: string;
    doctor_email: string;
    doctor_phone: number;
    doctor_specialty: string;
    doctor_password: string;
}
