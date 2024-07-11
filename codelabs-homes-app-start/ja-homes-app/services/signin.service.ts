import { Injectable } from '@angular/core';
import {SignIn} from "../src/app/sign-in";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SigninService {

  constructor(private http: HttpClient) { }
  private baseUrl = 'http://DEV-1261.mshome.net:8080/Project/webapi/secures';

  signIn(signIn: SignIn): Observable<any> {
    // @ts-ignore
    return this.http.get<any>(this.baseUrl);
  }
}
