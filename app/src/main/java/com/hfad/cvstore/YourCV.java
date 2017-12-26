package com.hfad.cvstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hfad.cvstore.database.CvDetail;
import com.hfad.cvstore.database.Education;
import com.hfad.cvstore.database.Project;
import com.hfad.cvstore.database.UserDataSource;

import java.util.ArrayList;

public class YourCV extends AppCompatActivity {

    private ArrayList<CvDetail> details;
    private ArrayList<Education> educations;
    private ArrayList<Project> projects;
    private UserDataSource source;
    private TextView cvDet,cvProject,cvedu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_cv);
        cvDet = findViewById(R.id.cvDet);
        cvProject=findViewById(R.id.cvProject);
        cvedu = findViewById(R.id.cvEdu);
        source = new UserDataSource(this);

        details=source.getCv();
        projects=source.getProject();
        educations=source.getEducationDetail();


        String title = details.get(0).getTitle().toString();
        String holder = details.get(0).getcVholder().toString();
        cvDet.setText(title+"\n"+holder+"\n");

        String projectName=projects.get(0).getProjectName().toString();
        String projectDesc=projects.get(0).getProjectDescription().toString();
        String projectLink=projects.get(0).getProjectLink().toString();
        cvProject.setText(projectName+"\n"+projectDesc+"\n"+projectLink+"\n");

        String degree = educations.get(0).getDegree().toString();
        String inst = educations.get(0).getInstitutionName().toString();
        String result = educations.get(0).getCgpa().toString();
        String year = educations.get(0).getYear().toString();
        cvedu.setText(degree+"\n"+inst+"\n"+result+"\n"+year+"\n");


    }
}
