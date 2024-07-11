export interface Schedule {
    schedule_id?: number; // Optional if you don't include this in the insert operation
    doctor_id: number;
    schedule_startTime: string;
    schedule_endTime: string;
    isAvailable: boolean;
}
