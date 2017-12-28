package com.hfad.cvstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int userId = users.get(position).getId();
                Intent intent = new Intent(UserList.this,YourCV.class);
                intent.putExtra("id",userId);
                startActivity(intent);
            }
        });

    }
}
