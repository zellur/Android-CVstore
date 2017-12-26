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
    public static final String CV_TABLE = "CVinfo";
    public static final String CV_PROJECT_TABLE = "Project";
    public static final String CV_EDUCATION_TABLE = "Education";
    //public static final String CV_DETAIL_TABLE = "CVdetail";

    public static final String USER_COL_ID = "User_id";
    public static final String USER_COL_NAME = "User_name";
    public static final String USER_COL_EMAIL = "User_email";
    public static final String USER_COL_PASSWORD = "User_password";
    public static final String USER_COL_PHONE = "User_phone";

    public static final String CV_COL_ID = "Cv_id";
    public static final String CV_COL_TITLE = "Cv_title";
    public static final String CV_COL_HOLDER = "Cv_holder";

    public static final String PROJECT_COL_ID = "Project_id";
    public static final String PROJECT_COL_NAME = "Project_name";
    public static final String PROJECT_COL_DESCRIPTION = "Project_desc";
    public static final String PROJECT_COL_LINK = "Project_link";

    public static final String EDUCATION_COL_ID = "Education_id";
    public static final String EDUCATION_COL_NAME = "Education_degree";
    public static final String EDUCATION_COL_INSTITUTE = "Education_inst";
    public static final String EDUCATION_COL_RESULT = "Education_result";
    public static final String EDUCATION_COL_PASS = "Education_passyear";


    public static final String CREATE_TABLE_USER = "CREATE TABLE "+USER_TABLE+"("+
            USER_COL_ID+" INTEGER PRIMARY KEY, "+
            USER_COL_NAME+" TEXT, "+
            USER_COL_EMAIL+" TEXT, "+
            USER_COL_PASSWORD+" TEXT, "+
            USER_COL_PHONE+" TEXT);";

    public static final String CREATE_TABLE_CVDETAIL = "CREATE TABLE "+CV_TABLE+"("+
            CV_COL_ID+" INTEGER PRIMARY KEY, "+
            CV_COL_TITLE+" TEXT, "+
            CV_COL_HOLDER+" TEXT);";


    public static final String CREATE_TABLE_PROJECT = "CREATE TABLE "+CV_PROJECT_TABLE+"("+
            PROJECT_COL_ID+" INTEGER PRIMARY KEY, "+
            PROJECT_COL_NAME+" TEXT, "+
            PROJECT_COL_DESCRIPTION+" TEXT, "+
            PROJECT_COL_LINK+" TEXT);";

    public static final String CREATE_TABLE_EDUCATION = "CREATE TABLE "+CV_EDUCATION_TABLE+"("+
            EDUCATION_COL_ID+" INTEGER PRIMARY KEY, "+
            EDUCATION_COL_NAME+" TEXT, "+
            EDUCATION_COL_INSTITUTE+" TEXT, "+
            EDUCATION_COL_RESULT+" TEXT, "+
            EDUCATION_COL_PASS+" TEXT);";

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_CVDETAIL);
        db.execSQL(CREATE_TABLE_PROJECT);
        db.execSQL(CREATE_TABLE_EDUCATION);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
