package com.hfad.cvstore;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.hfad.cvstore.database.User;

import java.util.ArrayList;

/**
 * Created by rakib on 12/25/17.
 */

public class UserAdapter extends ArrayAdapter {

    private Context context;
    ArrayList<User> users;

    public UserAdapter(@NonNull Context context, ArrayList<User> users) {
        super(context, R.layout.userlist,users);
        this.context=context;
        this.users=users;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       convertView = inflater.inflate(R.layout.userlist,parent,false);
        TextView username = convertView.findViewById(R.id.userna);
        TextView useremail=convertView.findViewById(R.id.userem);
        TextView userphone=convertView.findViewById(R.id.userph);
        Button update = convertView.findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = users.get(position).getId();
                Intent intent = new Intent(parent.getContext(),SignUp.class);
                intent.putExtra("id",id);
                parent.getContext().startActivity(intent);
            }
        });

        username.setText(users.get(position).getName());
        useremail.setText(users.get(position).getEmail());
        userphone.setText(users.get(position).getPhone());
        return convertView;
    }
}
