import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Doctor} from "../src/app/doctor";

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private baseUrl = 'http://DEV-1261.mshome.net:8080/Project/webapi/Patients';
  private headers= {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) {

  }

  insertPatient(doctor: any): Observable<any> {
    const headers = new HttpHeaders()
        .set('Content-Type', 'application/json');

    return this.http.post<any>(`${this.baseUrl}`, doctor, { headers });
  }

}
