package com.example.skillswap.logic;

import android.content.Context;
import android.database.Cursor;

import com.example.skillswap.models.Credential;
import com.example.skillswap.models.LoggedInUser;
import com.example.skillswap.models.Mentor;
import com.example.skillswap.repo.Data;
import com.example.skillswap.repo.DatabaseHelper;

public class Account {

    public static boolean login(Credential credential){

        for (Mentor mentor: Data.mentors) {

            if (mentor.getCredential().getEmail().equals(credential.getEmail()) && mentor.getCredential().getPassword().equals(credential.getPassword())){

                LoggedInUser.mentor = mentor;
                return true;

            }

        }

        return false;

    }

}
