package com.gita.model;

public class Shloka {

    private int number;
    private String sanskrit;
    private String meaning;
    private String guidance;

    public Shloka() {
    }

    public Shloka(int number, String sanskrit, String meaning, String guidance) {
        this.number = number;
        this.sanskrit = sanskrit;
        this.meaning = meaning;
        this.guidance = guidance;
    }

    // Getters & Setters
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public String getSanskrit() { return sanskrit; }
    public void setSanskrit(String sanskrit) { this.sanskrit = sanskrit; }
    public String getMeaning() { return meaning; }
    public void setMeaning(String meaning) { this.meaning = meaning; }
    public String getGuidance() { return guidance; }
    public void setGuidance(String guidance) { this.guidance = guidance; }
}
