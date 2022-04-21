package com.example.qamberhaider.mazdor_user;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Home extends AppCompatActivity {

    static String UID;
    private FirebaseAuth firebaseAuth;
    private String mSenderName;

    TextView profOpen;
    final Context context = this;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        getSupportFragmentManager().beginTransaction().replace(R.id.fram1,new Jobs_Fragment()).commit();

        profOpen = (TextView) findViewById(R.id.buttonShowCustomDialog);
        firebaseAuth = FirebaseAuth.getInstance();

        try {
            UID = firebaseAuth.getCurrentUser().getUid();

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            mSenderName = user.getEmail();
            profOpen.setText(mSenderName);
            Log.v("Loc", UID);
        }
        catch (Exception e){
            Toast.makeText(context, "Expection Applied", Toast.LENGTH_SHORT).show();
        }


        // Custom Dialog
        profOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.logout_layout);
                TextView text = (TextView) dialog.findViewById(R.id.profileName);
                text.setText(mSenderName);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogCancel);
                Button dialogLogout = (Button) dialog.findViewById(R.id.dialogLogut);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialogLogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        firebaseAuth.signOut();
                        Intent i = new Intent(Home.this, Login.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                });
                dialog.show();
            }
        });
    }







}
