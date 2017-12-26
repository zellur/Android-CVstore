package com.hfad.cvstore.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.icu.text.MessagePattern.ArgType.SELECT;

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

    public boolean insertCV(CvDetail cvDetail){

        this.open();

        ContentValues values = new ContentValues();
        values.put(UserDatabaseHelper.CV_COL_TITLE,cvDetail.getTitle());
        values.put(UserDatabaseHelper.CV_COL_HOLDER,cvDetail.getcVholder());

        long insertedRow = database.insert(UserDatabaseHelper.CV_TABLE,null,values);

        if(insertedRow>0){

            return true;
        }else{
            return false;
        }
    }

    public ArrayList<CvDetail> getCv(){

        this.open();

        ArrayList<CvDetail> cvDetails = new ArrayList<>();

        Cursor cursor = database.query(UserDatabaseHelper.CV_TABLE,null,null,null,null,null,null);

        if(cursor !=null && cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                int cvId = cursor.getInt(cursor.getColumnIndex(UserDatabaseHelper.CV_COL_ID));
                String cvTitle = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.CV_COL_TITLE));
                String cvHolder = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.CV_COL_HOLDER));

               cvDetails.add(new CvDetail(cvId,cvTitle,cvHolder));

            }while (cursor.moveToNext());

        }

        cursor.close();
        this.close();
        return cvDetails;


    }




    public boolean insertProject(Project project){

        this.open();

        ContentValues values = new ContentValues();
        values.put(UserDatabaseHelper.PROJECT_COL_NAME,project.getProjectName());
        values.put(UserDatabaseHelper.PROJECT_COL_DESCRIPTION,project.getProjectDescription());
        values.put(UserDatabaseHelper.PROJECT_COL_LINK,project.getProjectLink());

        long insertedRow = database.insert(UserDatabaseHelper.CV_PROJECT_TABLE,null,values);

        if(insertedRow>0){

            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Project> getProject(){

        this.open();

        ArrayList<Project> projects = new ArrayList<>();

        Cursor cursor = database.query(UserDatabaseHelper.CV_PROJECT_TABLE,null,null,null,null,null,null);

        if(cursor !=null && cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                int projectId = cursor.getInt(cursor.getColumnIndex(UserDatabaseHelper.PROJECT_COL_ID));
                String projectName = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.PROJECT_COL_NAME));
                String projectDesc = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.PROJECT_COL_DESCRIPTION));
                String projectLink = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.PROJECT_COL_LINK));

                projects.add(new Project(projectId,projectName,projectDesc,projectLink));

            }while (cursor.moveToNext());

        }

        cursor.close();
        this.close();
        return projects;

    }

    public boolean insertEducationDetail(Education education){

        this.open();

        ContentValues values = new ContentValues();
        values.put(UserDatabaseHelper.EDUCATION_COL_NAME,education.getDegree());
        values.put(UserDatabaseHelper.EDUCATION_COL_INSTITUTE,education.getInstitutionName());
        values.put(UserDatabaseHelper.EDUCATION_COL_RESULT,education.getCgpa());
        values.put(UserDatabaseHelper.EDUCATION_COL_PASS,education.getYear());

        long insertedRow = database.insert(UserDatabaseHelper.CV_EDUCATION_TABLE,null,values);

        if(insertedRow>0){

            return true;
        }else{
            return false;
        }
    }


    public ArrayList<Education> getEducationDetail(){

        this.open();

        ArrayList<Education> educations = new ArrayList<>();

        Cursor cursor = database.query(UserDatabaseHelper.CV_EDUCATION_TABLE,null,null,null,null,null,null);

        if(cursor !=null && cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                int eduId = cursor.getInt(cursor.getColumnIndex(UserDatabaseHelper.EDUCATION_COL_ID));
                String eduDegree = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.EDUCATION_COL_NAME));
                String eduInstitute = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.EDUCATION_COL_INSTITUTE));
                String eduResult = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.EDUCATION_COL_RESULT));
                String eduPassYear = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.EDUCATION_COL_PASS));


                educations.add(new Education(eduId,eduDegree,eduInstitute,eduResult,eduPassYear));

            }while (cursor.moveToNext());

        }

        cursor.close();
        this.close();
        return educations;

    }




    public String getSingleEntry(String userName){

        this.open();

        Cursor cursor=database.query(UserDatabaseHelper.USER_TABLE,null,UserDatabaseHelper.USER_COL_NAME+"=?",new String[]{userName},null,null,null);
        if(cursor.getCount()<1){
            cursor.close();

            return "not exist";
        }else {
            cursor.moveToFirst();
            String password = cursor.getString(cursor.getColumnIndex(UserDatabaseHelper.USER_COL_PASSWORD));
            cursor.close();
            this.close();
            return password;
        }
    }
}
