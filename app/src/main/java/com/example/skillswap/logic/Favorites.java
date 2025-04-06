package com.example.skillswap.logic;

import com.example.skillswap.models.Mentor;
import com.example.skillswap.models.Skill;
import com.example.skillswap.repo.Data;

public class Favorites {

    public static void add(Skill skill){

        Data.bookmarkedSkills.add(skill);

    }

    public static void remove(Skill skill){

        Data.bookmarkedSkills.remove(skill);

    }

}
