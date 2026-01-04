package com.gita.controller;

import com.gita.model.Chapter;
import com.gita.model.Shloka;
import com.gita.repository.GitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gita")
public class GitaController {

    @Autowired
    private GitaRepository repo;

    // 1️⃣ Get all chapters
    @GetMapping("/chapters")
    public List<Chapter> getChapters() {
        return repo.getAllChaptersList(); // Safe List conversion
    }

    // 2️⃣ Get all shlokas for a chapter
    @GetMapping("/chapter/{chapterNumber}")
    public Chapter getChapter(@PathVariable int chapterNumber) {
        return repo.getChapter(chapterNumber);
    }

    // 3️⃣ Get a single shloka by chapter + number
    @PostMapping("/shloka")
    public Shloka getShloka(@RequestBody ShlokaRequest request) {
        return repo.getShloka(request.getChapter(), request.getNumber());
    }

    // Request class for POST /shloka
    public static class ShlokaRequest {
        private int chapter;
        private int number;

        public int getChapter() {
            return chapter;
        }

        public void setChapter(int chapter) {
            this.chapter = chapter;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
