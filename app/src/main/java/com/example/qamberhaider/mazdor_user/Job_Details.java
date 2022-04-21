package com.example.qamberhaider.mazdor_user;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.qamberhaider.mazdor_user.RecyclerviewAdapter.KEY_DESC;
import static com.example.qamberhaider.mazdor_user.RecyclerviewAdapter.KEY_ID;
import static com.example.qamberhaider.mazdor_user.RecyclerviewAdapter.KEY_LOCATION;
import static com.example.qamberhaider.mazdor_user.RecyclerviewAdapter.KEY_RATE;
import static com.example.qamberhaider.mazdor_user.RecyclerviewAdapter.KEY_TITLE;
import static com.example.qamberhaider.mazdor_user.RecyclerviewAdapter.KEY_TYPE;

import com.example.qamberhaider.mazdor_user.Activities.ChatMessagesActivity;

public class Job_Details extends AppCompatActivity {


    String JobTitle = "" , JobLocation = ""  ;
    String JobType = "" , JobId = "";
    String Rate = "" , desc = "";
    FloatingActionButton fab ;
    //String Bc_no = "";

    public static final String KEY_UID="Emp_ID" ;
    public static final String KEY_NAME="Job_Name" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__details);


//    public static final String KEY_REGNO = "RegNo";

        Intent intent = getIntent();
        if (null != intent) {
            JobTitle = intent.getStringExtra(KEY_TITLE);
            JobLocation = intent.getStringExtra(KEY_LOCATION);
            Rate = intent.getStringExtra(KEY_RATE);
            desc = intent.getStringExtra(KEY_DESC);
            JobId = intent.getStringExtra(KEY_ID);
            //Bc_no = intent.getStringExtra(KEY_REGNO);
        }
        else {
            Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show();
        }

        TextView Applicant = (TextView) findViewById(R.id.jobTI);
        Applicant.setText(JobTitle);

        TextView UID = (TextView) findViewById(R.id.jobTy);
        UID.setText(JobLocation);

        TextView Regno = (TextView) findViewById(R.id.jobRa);
        Regno.setText(Rate);

        TextView Desc = (TextView) findViewById(R.id.des);
        Desc.setText(desc);

//        TextView Address = (TextView) findViewById(R.id.address);
//        Address.setText(address);

        System.out.println(JobTitle + "job_");

        fab = findViewById(R.id.fab) ;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), ChatMessagesActivity.class);
                intent.putExtra(KEY_UID, JobId );
                intent.putExtra(KEY_NAME, JobTitle );
                getBaseContext().startActivity(intent) ;

            }
        });

    }
}
