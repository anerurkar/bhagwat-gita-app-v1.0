import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Chapter } from '../models/chapter.model';

@Injectable({
  providedIn: 'root'
})
export class GitaService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getChapters(): Observable<Chapter[]> {
    return this.http.get<Chapter[]>(`${this.baseUrl}/chapters`);
  }
}
