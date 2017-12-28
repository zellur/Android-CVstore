package com.hfad.cvstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hfad.cvstore.database.User;
import com.hfad.cvstore.database.UserDataSource;

public class SignUp extends AppCompatActivity {

   private EditText name,email,passowrd,phone;
    private Button signup;
    private UserDataSource source;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.username);
       email = findViewById(R.id.useremail);
        passowrd = findViewById(R.id.userpass);
       phone = findViewById(R.id.userphone);
       signup = findViewById(R.id.signup2);
       source = new UserDataSource(this);

       id = getIntent().getIntExtra("id",0);

       if(id>0){

           User user = source.getUser(id);
           name.setText(user.getName());
           email.setText(user.getEmail());
           passowrd.setText(user.getPassword());
           phone.setText(user.getPassword());
           signup.setText("Update");
       }

       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (id > 0) {
                   String username = name.getText().toString();
                   String useremail = email.getText().toString();
                   String userpass = passowrd.getText().toString();
                   String userphone = phone.getText().toString();

                   boolean status = source.updateUser(new User(id,username, useremail, userpass, userphone));
                   if (status) {

                       Toast.makeText(SignUp.this, "user successfully updated", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(SignUp.this, MainActivity.class);
                       name.setText("");
                       email.setText("");
                       passowrd.setText("");
                       phone.setText("");
                       startActivity(intent);
                   } else {

                       Toast.makeText(SignUp.this, "failed to update", Toast.LENGTH_SHORT).show();
                   }


               } else {
                   String username = name.getText().toString();
                   String useremail = email.getText().toString();
                   String userpass = passowrd.getText().toString();
                   String userphone = phone.getText().toString();

                   boolean status = source.insertUser(new User(username, useremail, userpass, userphone));

                   if (status) {

                       Toast.makeText(SignUp.this, "user successfully added", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(SignUp.this, MainActivity.class);
                       name.setText("");
                       email.setText("");
                       passowrd.setText("");
                       phone.setText("");
                       startActivity(intent);

                   } else {

                       Toast.makeText(SignUp.this, "failed to insert", Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });
    }
}
