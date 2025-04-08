package com.example.skillswap.models;

import java.util.ArrayList;

public class Mentor {

    private int mentorId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
    private Credential credential;
    private int rating;
    private ArrayList<Skill> skills;


    public Mentor(int mentorId, String firstName, String lastName, String middleName, String email, String phone, Credential credential) {
        this.mentorId = mentorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phone = phone;
        this.credential = credential;

    }

    public Mentor(String firstName, String lastName, String middleName, String email, String phone, Credential credential) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phone = phone;
        this.credential = credential;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
