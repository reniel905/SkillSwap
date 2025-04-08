package com.example.skillswap.models;

public class Session {

    private int sessionId;
    private String skillRequested;
    private String prefferedMode;

    public Session(String skillRequested, String preferedMode) {
        this.skillRequested = skillRequested;
        this.prefferedMode = preferedMode;
    }

    public Session(int sessionId, String skillRequested, String prefferedMode) {
        this.sessionId = sessionId;
        this.skillRequested = skillRequested;
        this.prefferedMode = prefferedMode;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
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
