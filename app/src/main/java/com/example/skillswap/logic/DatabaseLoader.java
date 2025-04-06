package com.example.skillswap.logic;

import android.content.Context;
import android.database.Cursor;

import com.example.skillswap.models.Credential;
import com.example.skillswap.models.Mentor;
import com.example.skillswap.repo.Data;
import com.example.skillswap.repo.DatabaseHelper;

public class DatabaseLoader {

    Context context;

    public DatabaseLoader(Context context) {
        this.context = context;
    }

    public void loadMentors(){

        DatabaseHelper databaseHelper = new DatabaseHelper(context);

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
