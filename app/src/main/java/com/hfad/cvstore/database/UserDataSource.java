package com.hfad.cvstore.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by rakib on 12/25/17.
 */

public class UserDataSource {

    private UserDatabaseHelper helper;
    private SQLiteDatabase database;

    public UserDataSource(Context context) {
         helper = new UserDatabaseHelper(context);
    }

    public void open(){

        database = helper.getWritableDatabase();
    }

    public void close(){

        database.close();
    }

    public boolean insertUser(User user){

        this.open();

        ContentValues values = new ContentValues();
        values.put(UserDatabaseHelper.USER_COL_NAME,user.getName());
        values.put(UserDatabaseHelper.USER_COL_EMAIL,user.getEmail());
        values.put(UserDatabaseHelper.USER_COL_PASSWORD,user.getPassword());
        values.put(UserDatabaseHelper.USER_COL_PHONE,user.getPhone());

        long insertedRow = database.insert(UserDatabaseHelper.USER_TABLE,null,values);

        if(insertedRow>0){

            return true;
        }else{
            return false;
        }
    }

    public ArrayList<User> getUser(){

        this.open();

        ArrayList<User> users = new ArrayList<>();

       Cursor cursor = database.query(UserDatabaseHelper.USER_TABLE,null,null,null,null,null,null);

       if(cursor !=null && cursor.getCount() > 0){

           cursor.moveToFirst();

           do {
               int userId = cursor.getInt(cursor.getColumnIndex(UserDatabaseHelper.USER_COL_ID));
               String userName = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.USER_COL_NAME));
               String userEmail = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.USER_COL_EMAIL));
               String userPass = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.USER_COL_PASSWORD));
               String userPhone = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.USER_COL_PHONE));

               users.add(new User(userId,userName,userEmail,userPass,userPhone));

           }while (cursor.moveToNext());

       }

       cursor.close();
       this.close();
       return users;


    }
}
