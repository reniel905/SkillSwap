package com.example.skillswap.repo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.skillswap.models.Credential;
import com.example.skillswap.models.Mentor;
import com.example.skillswap.models.Skill;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "skillSwap.db";

    private static final int DATABASE_VERSION = 1;

    private static final String USER_TABLE = "Users";
    private static final String SKILL_TABLE = "Skills";


    private static final String BOOKMARK_TABLE = "Bookmarks";

    private static final String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + " (" +
            "user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "first_name TEXT, " +
            "last_name TEXT, " +
            "middle_name TEXT, " +
            "email TEXT, " +
            "phone TEXT, " +
            "password TEXT)";



    private static final String CREATE_SKILL_TABLE = "CREATE TABLE " + SKILL_TABLE + " (" +
            "skill_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "skill_name TEXT, " +
            "skill_description, " +
            "skill_level TEXT, " +
            "skill_catergory TEXT, " +
            "skill_time INTEGER)";

    private static final String CREATE_BOOKMARK_TABLE = "CREATE TABLE " + BOOKMARK_TABLE + " (" +
            "bookmark_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "user_id INTEGER, " +
            "cat_id INTEGER, " +
            "skill_id INTEGER, " +
            "FOREIGN KEY (user_id) REFERENCES Users(user_id), " +
            "FOREIGN KEY (skill_id) REFERENCES Skills(skill_id))";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_SKILL_TABLE);
        db.execSQL(CREATE_BOOKMARK_TABLE);
       // db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + USER_TABLE + " IF EXISTS");
        onCreate(db);

    }

    public boolean insertUser(Mentor mentor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("first_name", mentor.getFirstName());
        cv.put("last_name", mentor.getLastName());
        cv.put("middle_name", mentor.getMiddleName());
        cv.put("email", mentor.getEmail());
        cv.put("phone", mentor.getPhone());
        cv.put("password", mentor.getCredential().getPassword());
        long result = db.insert(USER_TABLE, null,cv);
        return result != -1;
    }



    public boolean insertSkill(Skill skill){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("skill_name", skill.getName());
        cv.put("skill_description", skill.getDescription());
        cv.put("skill_level", skill.getLevel());
        cv.put("skill_catergory", skill.getCategory());
        cv.put("skill_time", skill.getSkillTime());
        long result = db.insert(SKILL_TABLE, null,cv);
        return result != -1;
    }

    public boolean insertBookmark(Skill skill, int userId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("user_id", userId);
        cv.put("skill_name", skill.getName());
        long result = db.insert(BOOKMARK_TABLE, null,cv);
        return result != -1;
    }

    public boolean updateUser(Mentor mentor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("first_name", mentor.getFirstName());
        cv.put("last_name", mentor.getLastName());
        cv.put("middle_name", mentor.getMiddleName());
        cv.put("email", mentor.getEmail());
        cv.put("phone", mentor.getPhone());
        cv.put("password", mentor.getCredential().getPassword());
        int rowAffected = db.update(USER_TABLE, cv, "user_id=?", new String[]{String.valueOf(mentor.getMentorId())});
        return rowAffected < 0;
    }


    public Cursor getAllSkills(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + SKILL_TABLE,null);
    }

    public Cursor getAllUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + USER_TABLE,null);
    }

    public Cursor getBookMarksByUserId(int userId){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT Users.first_name, Users.last_name, Categories.cat_name, Skills.skill_name " +
                "FROM Bookmarks " +
                "INNER JOIN Bookmarks ON Users.user_id = Bookmarks.user_id " +
                "INNER JOIN Bookmarks ON Skills.skill_id = skill_id " +
                "WHERE Users.user_id=?",new String[]{String.valueOf(userId)});
    }


    public void deleteDatabase(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }
}
