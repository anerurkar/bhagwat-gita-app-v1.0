package com.gita.repository;

import com.gita.model.Chapter;
import com.gita.model.Shloka;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.*;

@Repository
public class GitaRepository {

    // Map<ChapterNumber, Chapter>
    private final Map<Integer, Chapter> chapters = new HashMap<>();

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Load all 18 chapters
            for (int i = 1; i <= 18; i++) {
                File file = new File("src/main/resources/gita/chapter-" + i + ".json");
                if (file.exists()) {
                    Chapter chapter = mapper.readValue(file, Chapter.class);
                    chapters.put(i, chapter);
                } else {
                    // Optional: create empty chapter if JSON missing
                    chapters.put(i, new Chapter(i, "Chapter " + i, new ArrayList<>()));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Gita chapters", e);
        }
    }

    // Get all chapters as Map
    public Map<Integer, Chapter> getAllChapters() {
        return chapters;
    }

    // Get all chapters as List
    public List<Chapter> getAllChaptersList() {
        return new ArrayList<>(chapters.values());
    }

    // Get specific chapter
    public Chapter getChapter(int chapterNumber) {
        return chapters.get(chapterNumber);
    }

    // Get specific shloka
    public Shloka getShloka(int chapterNumber, int shlokaNumber) {
        Chapter chapter = chapters.get(chapterNumber);
        if (chapter == null || chapter.getShlokas() == null || chapter.getShlokas().size() < shlokaNumber)
            return null;
        return chapter.getShlokas().get(shlokaNumber - 1); // 1-based indexing
    }
}
