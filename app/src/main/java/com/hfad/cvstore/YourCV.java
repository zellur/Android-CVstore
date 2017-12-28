package com.hfad.cvstore;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private TextView cvDet, cvProject, cvedu;
    private Button button;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_cv);
        cvDet = findViewById(R.id.cvDet);
        cvProject = findViewById(R.id.cvProject);
        cvedu = findViewById(R.id.cvEdu);
        button = findViewById(R.id.call);
        source = new UserDataSource(this);

        id = getIntent().getIntExtra("id", 2);

        details = source.getCv();
        projects = source.getProject();
        educations = source.getEducationDetail();


        String title = details.get(id).getTitle().toString();
        String holder = details.get(id).getcVholder().toString();
        cvDet.setText(title + "\n" + holder + "\n");

        String projectName = projects.get(id).getProjectName().toString();
        String projectDesc = projects.get(id).getProjectDescription().toString();
        String projectLink = projects.get(id).getProjectLink().toString();
        cvProject.setText(projectName + "\n" + projectDesc + "\n" + projectLink + "\n");

        String degree = educations.get(id).getDegree().toString();
        String inst = educations.get(id).getInstitutionName().toString();
        String result = educations.get(id).getCgpa().toString();
        String year = educations.get(id).getYear().toString();
        cvedu.setText(degree + "\n" + inst + "\n" + result + "\n" + year + "\n");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "12345";
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                if (ActivityCompat.checkSelfPermission(YourCV.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });


    }
}
