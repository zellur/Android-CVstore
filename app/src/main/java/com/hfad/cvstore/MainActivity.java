package com.hfad.cvstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.hfad.cvstore.database.UserDataSource;

public class MainActivity extends AppCompatActivity {

    private Button signin,signup,findcv;
    private EditText loginName,loginPassword;
    private UserDataSource source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin=findViewById(R.id.signin);
        signup = findViewById(R.id.signup);
        findcv =findViewById(R.id.find);
        loginName=findViewById(R.id.loginname);
        loginPassword=findViewById(R.id.loginpass);
        source = new UserDataSource(MainActivity.this);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = loginName.getText().toString();
                String userPass = loginPassword.getText().toString();
                String storedPass = source.getSingleEntry(userName);
                if(userPass.equals(storedPass)){

                    Toast.makeText(MainActivity.this, "Welcome to CV store", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,CreateCv.class);
                    loginName.setText("");
                    loginPassword.setText("");
                    startActivity(intent);


                }else{

                    Toast.makeText(MainActivity.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);

            }
        });

        findcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UserList.class));
            }
        });
    }
}
