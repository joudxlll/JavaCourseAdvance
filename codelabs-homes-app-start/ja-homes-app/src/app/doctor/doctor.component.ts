import { Component } from '@angular/core';
import {DoctorService} from "../../../services/doctor.service";
import {NgForOf, NgIf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {Doctor} from "../doctor";

@Component({
  selector: 'app-doctor', //we import using this
  templateUrl: './doctor.component.html',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    FormsModule
  ],
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent {
  filter: any = {}; // Object to hold filter parameters

  protected data: any[] | undefined;
  //
  // newDoctor: Doctor = {
  //   doctor_name: '',
  //   doctor_email: '',
  //   doctor_phone: 0,
  //   doctor_specialty: '',
  //   doctor_password: ''
  // };
  constructor(private doctorService: DoctorService) {
  }

  // ngOnInit(){
  //   this.doctorService.getAllDoctors().subscribe(doctors => {
  //     this.data = doctors;
  //     console.log(this.data)})
  // }
  //
  onSearch() {
    this.doctorService.getDoctorsBySearch(this.filter).subscribe(doctors => {
      this.data = doctors;
      console.log(this.data);
    });
  }


  // onSubmit(): void {
  //   this.doctorService.addDoctor(this.newDoctor).subscribe(
  //       (response) => {
  //         console.log('Doctor inserted successfully:', response);
  //         console.log('Schedule:', this.newDoctor);
  //
  //       },
  //   );
  // }
}
