import {Routes} from "@angular/router";
import {DoctorComponent} from "./doctor/doctor.component";
import {PatientConsultationComponent} from "./Consultation/patientConsultation/patientConsultation.component";
import {MedicalReportComponent} from "./medical-report/medical-report.component";
import {ScheduleComponent} from "./schedule/schedule.component";
import {DoctorSignComponent} from "./doctor-sign/doctor-sign.component";
import {DoctorDashboardComponent} from "./doctor-dashboard/doctor-dashboard.component";
import {DoctorConsultationComponent} from "./Consultation/doctor-consultation/doctor-consultation.component";
import {PatientDashboardComponent} from "./patient-dashboard/patient-dashboard.component";
import {PatientSignComponent} from "./patient-sign/patient-sign.component";

const routeConfig: Routes = [
    // {
    //     path: '',
    //     redirectTo: "sign in",
    //     pathMatch: 'full'
    // },

    {
        path: 'doctorDashboard',
        component: DoctorDashboardComponent,
        children: [
            {
                path: 'schedule',
                component: ScheduleComponent,
            },
            {
                path: 'consultation-requests',
                component: DoctorConsultationComponent,
            },
            {
                path: 'search-patients-MR',
                component: MedicalReportComponent,
            },
            // Add more routes for other functionalities
        ]
    },

    {
        path: 'patientDashboard',
        component: PatientDashboardComponent,
        children: [
            {
                path: 'doctor-search',
                component: DoctorComponent,
            },
            {
                path: 'consultation-requests',
                component: PatientConsultationComponent,
            },
            {
                path: 'patient-MR',
                component: MedicalReportComponent,
            },
            // Add more routes for other functionalities
        ]
    },
    {
        path: 'signPatient',
        component: PatientSignComponent,
    },
    {
        path: 'signDoctor',
        component: DoctorSignComponent,
    },
    {
        path: 'doctor',
        component: DoctorComponent,
        title: 'Doctor Page'
    },
    {
        path: 'consultation',
        component: PatientConsultationComponent,
        title: 'Consultation Page'
    },
    {
        path: 'medical reports',
        component: MedicalReportComponent,
        title: 'Medical Reports Page'
    },
    {
        path: 'schedule',
        component: ScheduleComponent,
        title: 'Consultation Page'
    },

];

export default routeConfig;