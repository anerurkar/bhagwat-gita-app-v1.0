import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

interface Shloka {
  number: number;
  sanskrit: string;
  meaning: string;
  guidance: string;
}

interface Chapter {
  chapter: number;   // match backend response
  title: string;
  shlokas: Shloka[];
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  chapters: Chapter[] = [];
  shlokas: Shloka[] = [];

  selectedChapter: number | null = null;
  selectedShloka: number | null = null;
  private chaptersUrl = environment.apiBaseUrl + '/api/gita/chapters';

  constructor(private http: HttpClient) {
  console.log('Cloud Run API:', environment.apiBaseUrl);
  console.log('chaptersUrl:', chaptersUrl);
  }

  ngOnInit(): void {
    this.loadChapters();
  }

  loadChapters(): void {
    //this.http.get<Chapter[]>('https://kshna-svc-100157816972.asia-south1.run.app/api/gita/chapters')
	this.http.get<Chapter[]>(this.chaptersUrl)
      .subscribe({
        next: data => this.chapters = data,
        error: err => console.error('Error loading chapters', err)
      });
  }

  loadShlokas(): void {
    const chapter = this.chapters.find(c => c.chapter === this.selectedChapter);
    this.shlokas = chapter ? chapter.shlokas : [];
    this.selectedShloka = null;
  }

  get selectedShlokaText(): Shloka | undefined {
    return this.shlokas.find(s => s.number === this.selectedShloka);
  }

  get selectedChapterTitle(): string {
    const chapter = this.chapters.find(c => c.chapter === this.selectedChapter);
    return chapter ? chapter.title : '';
  }
}
