import { Component, OnInit } from '@angular/core';
import { GitaService } from '../../services/gita.service';
import { Chapter } from '../../models/chapter.model';

@Component({
  selector: 'app-chapters',
  templateUrl: './chapters.component.html',
})
export class ChaptersComponent implements OnInit {
  chapters: Chapter[] = [];

  constructor(private gitaService: GitaService) {}

  ngOnInit(): void {
    this.gitaService.getChapters().subscribe(data => {
      this.chapters = data;
    });
  }
}
