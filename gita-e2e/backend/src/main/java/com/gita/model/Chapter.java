package com.gita.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Chapter {

    @JsonProperty("chapter")
	private int chapterNumber;
    private String title;
    private List<Shloka> shlokas;

    // ✅ No-arg constructor required by Jackson
    public Chapter() {
    }

    // ✅ Constructor for manual creation
    public Chapter(int chapterNumber, String title, List<Shloka> shlokas) {
        this.chapterNumber = chapterNumber;
        this.title = title;
        this.shlokas = shlokas;
    }

    // Getters & Setters
    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Shloka> getShlokas() {
        return shlokas;
    }

    public void setShlokas(List<Shloka> shlokas) {
        this.shlokas = shlokas;
    }
}
