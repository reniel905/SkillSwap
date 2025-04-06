package com.example.skillswap;

import android.app.Application;
import android.database.Cursor;

import com.example.skillswap.models.Credential;
import com.example.skillswap.models.Mentor;
import com.example.skillswap.repo.Data;
import com.example.skillswap.repo.DatabaseHelper;

public class SkillSwap extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Data.accountsInit();
        loadMentors();

    }

    public void loadMentors(){

        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());

        Cursor cursor = databaseHelper.getAllUsers();

        while (cursor.moveToNext()){

            Data.mentors.add(new Mentor(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    new Credential(
                            cursor.getString(6),
                            cursor.getString(4)
                    )

            ));

        }

    }

}
