package com.example.qamberhaider.mazdor_user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by qamber.haider on 4/17/2018.
 */

public class Jobs_Fragment extends Fragment {

    public Jobs_Fragment(){

    }

    public final static String Database_Path = "JOBS"; // Root Database Name for Firebase Database.
    static String UID;
    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog ;
    List<Job_class> list;
    RecyclerView recyclerview;
//    EditText SearchView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.jobs, container, false);

        recyclerview = (RecyclerView) v.findViewById(R.id.rview);
//        SearchView = (EditText)v.findViewById(R.id.search_view);

//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference(Database_Path);
        mDatabase.keepSynced(true);
        firebaseAuth = FirebaseAuth.getInstance();


        //search bar
//        SearchView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//                if (!s.toString().isEmpty()){
//                    search(s.toString());
//                    Log.i(s.toString(),"ValueS");
//                }
//                else {
//                    search("");
//                }
//
//            }
//        });



        progressDialog = new ProgressDialog(getContext());

        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);

        progressDialog.show();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                // StringBuffer stringbuffer = new StringBuffer();

                try {
                    for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                        Job_class userdetails = dataSnapshot1.getValue(Job_class.class);

                            Job_class listdata = new Job_class() ;

                            listdata.setJob_title(userdetails.getJob_title());
                            listdata.setJob_location(userdetails.getJob_location());
                            listdata.setJob_rate(userdetails.getJob_rate());
                            listdata.setJob_id( userdetails.getJob_id() );

                            list.add(listdata);
                            progressDialog.dismiss();

                    }
                }
                catch (Exception e) {
                        Toast.makeText(getContext(), "Exception applied", Toast.LENGTH_LONG).show();
                        Log.e(e.getClass().getName(), e.getMessage(), e);
                        progressDialog.dismiss();
                }

                RecyclerviewAdapter recycler = new RecyclerviewAdapter(getActivity(),list);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getContext());
                recyclerview.setLayoutManager(layoutmanager);
                recyclerview.setItemAnimator( new DefaultItemAnimator());
                recyclerview.setAdapter(recycler);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //  Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(getContext(), "No post Uploaded Yet", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

//
//    public void search(String s){
//
//        Query query = mDatabase.orderByChild("job_title")
//                .startAt(s)
//                .endAt(s + "\uf8ff");
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if(dataSnapshot.hasChildren()){
//                    list.clear();
//                    for (DataSnapshot dss:dataSnapshot.getChildren()){
//                        final  Listdata data = dss.getValue(Listdata.class);
//                        list.add(data);
//                    }
//
//                    RecyclerviewAdapter recycler = new RecyclerviewAdapter(getActivity(),list);
//                    recyclerview.setAdapter(recycler);
//                    recycler.notifyDataSetChanged();
//
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }


}
