import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Chapter } from '../models/chapter.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GitaService {
 
  
  private basehttpsUrl1 = 'https://kshna-svc-100157816972.asia-south1.run.app';

  constructor(private http: HttpClient) {
  console.log('GitaService basehttpsUrl =', this.basehttpsUrl1);
  }

  getChapters(): Observable<Chapter[]> {
    return this.http.get<Chapter[]>(`${this.basehttpsUrl1}/api/gita/chapters`);
  }
}
