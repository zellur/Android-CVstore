package com.hfad.cvstore.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rakib on 12/25/17.
 */

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "cvdatabase";
    public static final int DATABASE_VERSION = 1;

    public static final String USER_TABLE = "User";

    public static final String USER_COL_ID = "User_id";
    public static final String USER_COL_NAME = "User_name";
    public static final String USER_COL_EMAIL = "User_email";
    public static final String USER_COL_PASSWORD = "User_password";
    public static final String USER_COL_PHONE = "User_phone";

    public static final String CREATE_TABLE_USER = "CREATE TABLE "+USER_TABLE+"("+
            USER_COL_ID+" INTEGER PRIMARY KEY, "+
           USER_COL_NAME+" TEXT, "+
           USER_COL_EMAIL+" TEXT, "+
           USER_COL_PASSWORD+" TEXT, "+
           USER_COL_PHONE+" TEXT);";

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
