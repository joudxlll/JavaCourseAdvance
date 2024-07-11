import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ConsultationService {

  private baseUrl = 'http://DEV-1261.mshome.net:8080/Project/webapi/Consultations';
  private headers= {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private http: HttpClient) { }

  getAllCon(): Observable<any[]>{ //[] if the return is array
    // @ts-ignore
    return this
        .http
        .get<any[]>(this.baseUrl)
  }

  getPendingConsultation(filter: any): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl, { params: filter });
  }

  getConsultationById(consultationId: number): Observable<any> {
    return this.http.get<any>(`http://DEV-1261.mshome.net:8080/Project/webapi/Consultations/${consultationId}`);
  }

  insertConsultation(consultation: any): Observable<any> {
    const headers = new HttpHeaders()
        .set('Content-Type', 'application/json');

    return this.http.post<any>(`${this.baseUrl}`, consultation, { headers });
  }

  updateConsultation(consultationId: number, consultation: any): Observable<any> {
    const headers = new HttpHeaders()
        .set('Content-Type', 'application/json');

    return this.http.put<any>(`${this.baseUrl}/${consultationId}`, consultation, { headers });
  }

  updateConsultationRate(consultationId: number, consultation: any): Observable<any> {
    const headers = new HttpHeaders()
        .set('Content-Type', 'application/json');

    return this.http.put<any>(`${this.baseUrl}/Rate/${consultationId}`, consultation, { headers });
  }


}
