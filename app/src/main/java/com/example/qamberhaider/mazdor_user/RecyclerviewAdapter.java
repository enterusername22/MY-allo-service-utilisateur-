package com.example.qamberhaider.mazdor_user;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by qamber.haider on 4/25/2018.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyHolder> {

    List<Job_class> listdata;
    private Context mContext;

    public static final String KEY_TITLE="TITLE";
    public static final String KEY_TYPE="TYPE";
    public static final String KEY_DESC="DESC";
    public static final String KEY_RATE = "RATE";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_ID = "ID";
//    public static final String KEY_REGNO = "RegNo";


    public RecyclerviewAdapter(Context contexts, List<Job_class> listdata) {
        this.mContext = contexts;
        this.listdata = listdata;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_jobs,parent,false);

        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
        Job_class data = listdata.get(position);
        holder.vname.setText(data.getJob_title());
        holder.vemail.setText(data.getJob_location());
        holder.vaddress.setText(data.getJob_location());


        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean Onclick) {

                Job_class listdata1 = listdata.get(position);

                Toast.makeText(mContext, "Hello", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,Job_Details.class);
                intent.putExtra(KEY_TITLE, listdata1.getJob_title());
                intent.putExtra(KEY_DESC, listdata1.getJob_description());
                intent.putExtra(KEY_LOCATION, listdata1.getJob_location() );
                intent.putExtra(KEY_RATE, listdata1.getJob_rate());
                intent.putExtra(KEY_ID, listdata1.getJob_id());
                //intent.putExtra(KEY_REGNO,dataModel.getRegno());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    public static  class  MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView vname , vaddress, vemail;
        private ItemClickListener clickListener;


        public MyHolder(View itemView) {
            super(itemView);
            vname = (TextView) itemView.findViewById(R.id.title);
            vemail = (TextView) itemView.findViewById(R.id.text_Job);
            vaddress = (TextView) itemView.findViewById(R.id.rate);
            itemView.setOnClickListener(this);

        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }
    }

    public void filterList(ArrayList<Job_class> filterList){
        listdata = filterList;
        notifyDataSetChanged();

    }


}