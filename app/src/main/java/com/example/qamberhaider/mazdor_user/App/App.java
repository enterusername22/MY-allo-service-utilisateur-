package com.example.qamberhaider.mazdor_user.App;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by qamber.haider on 12/1/2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //set database to persist
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}