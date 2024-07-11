import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Consultation} from "../src/app/consultation";
import {Schedule} from "../src/app/schedule";

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  private baseUrl = 'http://DEV-1261.mshome.net:8080/Project/webapi/Schedule/';
  private headers= {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  getScheduleByDoctorId(docId: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}${docId}`);
  }

  insertSchedule(schedule: any): Observable<any> {
    const headers = new HttpHeaders()
        .set('Content-Type', 'application/json');

    return this.http.post<any>(`${this.baseUrl}`, schedule, { headers });
  }

  updateSchedule(scheduleId: number,schedule: any): Observable<any> {
    const headers = new HttpHeaders()
        .set('Content-Type', 'application/json');

    return this.http.put<any>(`${this.baseUrl}/${scheduleId}`, schedule, { headers });
  }
}
