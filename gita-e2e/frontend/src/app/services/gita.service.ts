import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Chapter } from '../models/chapter.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GitaService {
 // private baseUrl = 'http://localhost:8080';
//  private basehttpsUrl = 'https://kshna-svc-100157816972.asia-south1.run.app';
  private basehttpsUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {
  console.log('GitaService basehttpsUrl =', this.basehttpsUrl);
  }

  getChapters(): Observable<Chapter[]> {
    return this.http.get<Chapter[]>(`${this.basehttpsUrl}/api/gita/chapters`);
  }
}
