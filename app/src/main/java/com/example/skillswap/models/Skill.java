package com.example.skillswap.models;

public class Skill {

    private int skillId;
    private int image;
    private String name;
    private String description;
    private String level;
    private String category;
    private int skillTime;
    private boolean isBookmarked;

    public Skill(int skillId, int image, String name, String description, String level, String category, int skillTime) {
        this.skillId = skillId;
        this.image = image;
        this.name = name;
        this.description = description;
        this.level = level;
        this.category = category;
        this.skillTime = skillTime;
        this.isBookmarked = false;
    }

    public Skill(String name, String category) {
        this.name = name;
        this.category = category;
        this.isBookmarked = false;
    }

    public Skill(int skillId, String name, String category, int skillTime) {
        this.skillId = skillId;
        this.name = name;
        this.category = category;
        this.skillTime = skillTime;
        this.isBookmarked = false;
    }

    public Skill(int image, String name, String description, String level, String category, int skillTime) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.level = level;
        this.category = category;
        this.skillTime = skillTime;
        this.isBookmarked = false;
    }

    public boolean isBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        isBookmarked = bookmarked;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getSkillTime() {
        return skillTime;
    }

    public void setSkillTime(int skillTime) {
        this.skillTime = skillTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
