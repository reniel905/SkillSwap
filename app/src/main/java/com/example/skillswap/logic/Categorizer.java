package com.example.skillswap.logic;

import com.example.skillswap.models.Skill;
import com.example.skillswap.repo.Data;

import java.util.ArrayList;

public class Categorizer {

    static ArrayList<Skill> skills = Data.skills;

    public static ArrayList<Skill> Tech(){


        ArrayList<Skill> categorizedSkills = new ArrayList<>();

        for (Skill skill: skills) {


            if (skill.getCategory().equals("Technology & Coding")){

                categorizedSkills.add(skill);

            }

        }

        return categorizedSkills;
    }

    public static ArrayList<Skill> Arts(){

        ArrayList<Skill> categorizedSkills = new ArrayList<>();

        for (Skill skill: skills) {


            if (skill.getCategory().equals("Arts & Crafts")){

                categorizedSkills.add(skill);

            }

        }

        return categorizedSkills;
    }

    public static ArrayList<Skill> Fitness(){

        ArrayList<Skill> categorizedSkills = new ArrayList<>();

        for (Skill skill: skills) {


            if (skill.getCategory().equals("Fitness & Wellness")){

                categorizedSkills.add(skill);

            }

        }

        return categorizedSkills;
    }

    public static ArrayList<Skill> Language(){

        ArrayList<Skill> categorizedSkills = new ArrayList<>();

        for (Skill skill: skills) {


            if (skill.getCategory().equals("Language & Communication")){

                categorizedSkills.add(skill);

            }

        }

        return categorizedSkills;
    }

    public static ArrayList<Skill> Business(){

        ArrayList<Skill> categorizedSkills = new ArrayList<>();

        for (Skill skill: skills) {


            if (skill.getCategory().equals("Business & Finance")){

                categorizedSkills.add(skill);

            }

        }

        return categorizedSkills;
    }


}
