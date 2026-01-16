package com.gita.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Chapter {

    @JsonProperty("chapter")
	private int chapterNumber;
    private String title;
    private List<Shloka> shlokas;
	private int totalNoOfShlokas;

    // ✅ No-arg constructor required by Jackson
    public Chapter() {
    }

    // ✅ Constructor for manual creation
    public Chapter(int chapterNumber, String title, List<Shloka> shlokas,int totalNoOfShlokas ) {
        this.chapterNumber = chapterNumber;
        this.title = title;
        this.shlokas = shlokas;
		this.totalNoOfShlokas=totalNoOfShlokas;
    }

    // Getters & Setters
    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }
 // Getters & Setters
    public int getTotalNoOfShlokas() {
        return totalNoOfShlokas;
    }

    public void setTotalNoOfShlokas(int totalNoOfShlokas) {
        this.totalNoOfShlokas = totalNoOfShlokas;
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
