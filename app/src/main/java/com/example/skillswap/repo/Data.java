package com.example.skillswap.repo;

import com.example.skillswap.R;
import com.example.skillswap.models.Credential;
import com.example.skillswap.models.Mentor;
import com.example.skillswap.models.Session;
import com.example.skillswap.models.Skill;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Skill> skills = new ArrayList<>();
    public static ArrayList<Skill> bookmarkedSkills = new ArrayList<>();
    public static ArrayList<Mentor> mentors = new ArrayList<>();
    public static ArrayList<Session> requestedSessions = new ArrayList<>();

    public static void accountsInit(){

        mentors.add(new Mentor(0, "Alex", "Oro", "A", "alex@marikina.com", "09099146061", new Credential( "alex@marikina.com", "admin")));
        mentors.add(new Mentor(1, "Reniel", "Baldove", "G", "reniel@marikina.com", "09123948590", new Credential( "reniel@marikina.com" , "admin1")));
        mentors.add(new Mentor(2, "Elmer Jr.", "Felisilda", "G", "elmer@marikina.com", "09123446790", new Credential( "elmer@marikina.com" , "admin2")));

    }

    public static void skillsInit(){

        skills.add(new Skill(R.drawable.stock_market,"Basic of Stock Market Investing","You gonna be like pro broker in no time","Advanced","Business & Finance",8));
        skills.add(new Skill(R.drawable.basic_yoga,"Basic Yoga Poses","This is like a meditation ripoff, but with body movements","Intermediate","Fitness & Wellness",6));
        skills.add(new Skill(R.drawable.calligraphy,"Calligraphy & Hand Lettering","Enhance your lettering skills like Sun Tzu in the golden river","Beginner","Arts & Crafts",10));
        skills.add(new Skill(R.drawable.spanish,"Conversational Spanish","You will learn how to sing Despacito in no time","Intermediate","Language & Communication",8));
        skills.add(new Skill(R.drawable.digital_illustration,"Digital Illustration for Beginners","It's like Canva, but like a pro.","Beginner","Arts & Crafts",6));
        skills.add(new Skill(R.drawable.diy_home,"DIY Home Decor","Design your home like pro architect!","Beginner","Arts & Crafts",4));
        skills.add(new Skill(R.drawable.smart_home,"How to Set Up a Smart Home","You will learn how to be like Iron-man","Beginner","Technology & Coding",6));
        skills.add(new Skill(R.drawable.intro_python,"Intro to Python","Python is very very good programming language like a flexible snake-kun.","Intermediate","Technology & Coding", 12));
        skills.add(new Skill(R.drawable.meditation,"Meditation Techniques","Attain the enlightment you are seeking","Intermediate","Fitness & Wellness",3));
        skills.add(new Skill(R.drawable.public_speaking,"Public Speaking & Confidence","Speak like Obama in no time","Beginner","Language & Communication",4));
        skills.add(new Skill(R.drawable.social_media,"Social Media Marketing for Small Businesses","Enhance your your marketing strategy for your business using the social media","Intermediate","Business & Finance",6));
        skills.add(new Skill(R.drawable.strength_training,"Strength Training for Beginners","To those who seek to be like Saitama","Beginner","Fitness & Wellness",4));
        skills.add(new Skill(R.drawable.time_management,"Time Management Strategies","Manage your time so you have time for your love ones","Intermediate","Business & Finance",6));


        //Technology & Coding
        skills.add(new Skill(R.drawable.web_dev,"Web Development Basics","Web Dev is so so good like a sweet muffin.","Advanced","Technology & Coding",12));

        //Arts & Crafts

        //Fitness & Wellness

        //Language & Communication
        skills.add(new Skill(R.drawable.resume,"Writing a Resume that Stands Out","A resume that is out of this world!","Beginner","Language & Communication",2));

        //Business & Finance

    }
}
