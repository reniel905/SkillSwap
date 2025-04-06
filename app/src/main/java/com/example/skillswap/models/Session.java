package com.example.skillswap.models;

public class Session {

    private String skillRequested;
    private String prefferedMode;

    public Session(String skillRequested, String preferedMode) {
        this.skillRequested = skillRequested;
        this.prefferedMode = preferedMode;
    }

    public String getSkillRequested() {
        return skillRequested;
    }

    public void setSkillRequested(String skillRequested) {
        this.skillRequested = skillRequested;
    }

    public String getPrefferedMode() {
        return prefferedMode;
    }

    public void setPrefferedMode(String prefferedMode) {
        this.prefferedMode = prefferedMode;
    }
}
