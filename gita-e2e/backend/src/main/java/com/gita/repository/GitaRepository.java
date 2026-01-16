package com.gita.repository;

import com.gita.model.Chapter;
import com.gita.model.Shloka;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class GitaRepository {

    // In-memory cache: ChapterNumber -> Chapter
    private final Map<Integer, Chapter> chapters = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Load all 18 chapters ONCE at startup
            for (int i = 1; i <= 18; i++) {

                InputStream is = getClass()
                        .getClassLoader()
                        .getResourceAsStream("gita/chapter-" + i + ".json");

                if (is != null) {
                    Chapter chapter = mapper.readValue(is, Chapter.class);
					  // Ensure totalShlokas is set (important)
                    if (chapter.getShlokas() != null) {
                        //chapter.setTotalShlokas(chapter.getShlokas().size());
						chapter.setTotalNoOfShlokas(chapter.getShlokas().size());
                    }
                    chapters.put(i, chapter);
                } else {
                    // Fallback safety (should not happen)
                    chapters.put(i,
                            new Chapter(i, "Chapter " + i, new ArrayList<>(),0));
                }
            }

            System.out.println("✅ Bhagavad Gita chapters loaded into memory cache");

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to load Gita chapters", e);
        }
    }

    // Get all chapters
    public List<Chapter> getAllChaptersList() {
        return new ArrayList<>(chapters.values());
    }

    // Get a single chapter
    public Chapter getChapter(int chapterNumber) {
        return chapters.get(chapterNumber);
    }

    // Get a single shloka (1-based index)
    public Shloka getShloka(int chapterNumber, int shlokaNumber) {
        Chapter chapter = chapters.get(chapterNumber);

        if (chapter == null ||
            chapter.getShlokas() == null ||
            shlokaNumber < 1 ||
            shlokaNumber > chapter.getShlokas().size()) {
            return null;
        }

        return chapter.getShlokas().get(shlokaNumber - 1);
    }
}
