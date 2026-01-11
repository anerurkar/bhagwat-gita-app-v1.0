package com.gita.service;

import com.gita.model.Shloka;
import com.gita.repository.GitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitaService {

    @Autowired
    private GitaRepository repo;

    // Get all chapters
    public Object getAllChapters() {
        return repo.getAllChaptersList();
    }

    // Get shlokas for a chapter
    public Object getShlokasForChapter(int chapterNumber) {
        return repo.getChapter(chapterNumber) != null ? repo.getChapter(chapterNumber).getShlokas() : null;
    }

    // Get a single shloka
    public Shloka getShloka(int chapterNumber, int shlokaNumber) {
        return repo.getShloka(chapterNumber, shlokaNumber);
    }
}
