package com.hfad.cvstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.hfad.cvstore.database.User;
import com.hfad.cvstore.database.UserDataSource;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    private ListView list;
    private ArrayList<User> users;
    private UserDataSource source;
    private UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        list = findViewById(R.id.userlist);
        source=new UserDataSource(this);
        users = source.getUser();
        adapter = new UserAdapter(this,users);
        list.setAdapter(adapter);

    }
}
