import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MedicalRecordsService {

  constructor(private http: HttpClient) { }

  getAllMedicalReports(patient_id: number): Observable<any[]> {
    return this.http.get<any[]>(`http://DEV-1261.mshome.net:8080/Project/webapi/MR/${patient_id}`);
  }}
