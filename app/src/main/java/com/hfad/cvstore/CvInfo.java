package com.hfad.cvstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hfad.cvstore.database.CvDetail;
import com.hfad.cvstore.database.Education;
import com.hfad.cvstore.database.Project;
import com.hfad.cvstore.database.UserDataSource;

public class CvInfo extends AppCompatActivity {

private EditText cvTitle,cvName,projectName,projectDesc,projectLink,eduDegree,eduIns,eduResult,eduPassYear;
    private Button save;
    private UserDataSource source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_info);

        cvTitle = findViewById(R.id.title);
        cvName = findViewById(R.id.holder);
        projectName = findViewById(R.id.projectName);
        projectDesc = findViewById(R.id.projectDesc);
        projectLink = findViewById(R.id.projectLink);
        eduDegree = findViewById(R.id.degree);
        eduIns = findViewById(R.id.institution);
        eduResult = findViewById(R.id.result);
        eduPassYear = findViewById(R.id.passYear);
        save = findViewById(R.id.saveInfo);
        source = new UserDataSource(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = cvTitle.getText().toString();
                String holder = cvName.getText().toString();
                String projectNa = projectName.getText().toString();
                String projectDe = projectDesc.getText().toString();
                String projectLi = projectLink.getText().toString();
                String eduDe = eduDegree.getText().toString();
                String eduIn = eduIns.getText().toString();
                String eduRe = eduResult.getText().toString();
                String eduPas = eduPassYear.getText().toString();


                boolean statusOne = source.insertCV(new CvDetail(title,holder));
                boolean statusTwo = source.insertProject(new Project(projectNa,projectDe,projectLi));
                boolean statusThree = source.insertEducationDetail(new Education(eduDe,eduIn,eduRe,eduPas));

                if (statusOne && statusTwo && statusThree){

                    Toast.makeText(CvInfo.this, "Your CV has been saved successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CvInfo.this,UserList.class);
                    startActivity(intent);
                } else{

                    Toast.makeText(CvInfo.this, "Insertion failed", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
