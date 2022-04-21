package com.example.qamberhaider.mazdor_user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qamberhaider.mazdor_user.Activities.ChatMessagesActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by qamber.haider on 5/23/2018.
 */

public class Pro_RecycleviewAdapter extends RecyclerView.Adapter<Pro_RecycleviewAdapter.ViewHolder> {

    private final Context Context;
    private List<Listdata_Pro>  mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    public static final String KEY_UID="Emp_ID";
    public static final String KEY_NAME="Emp_Name";




    Pro_RecycleviewAdapter(Context context, List<Listdata_Pro> data) {
        this.Context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.view_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        final Listdata_Pro info = mData.get(position);

        holder.vname.setText(info.getPrFirstName());
        holder.V_desig.setText(info.getPrDesignation());
        holder.vEEmail.setText(info.getPrEmail());
        holder.v_nic.setText(info.getPrNic());
        holder.v_phone.setText(info.getPrTelephone());
        holder.V_empID.setText(info.getPrid());
        Picasso.get()
                .load(info.getPrProfilepicture())
                .placeholder(R.mipmap.place_avatar)
                .resize(50, 50)
                .centerCrop()
                .into(holder.v_pic);



        //chat channel
        holder.sendMessaAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(Context, "chat", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Context,ChatMessagesActivity.class);
                intent.putExtra(KEY_UID, info.getPrid());
                intent.putExtra(KEY_NAME, info.getPrFirstName());
                Context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView vname , V_desig,v_nic,vEEmail, v_phone,V_empID;
        CircleImageView v_pic;
        ImageView sendMessaAc;


        ViewHolder(View itemView) {
            super(itemView);
            vname = (TextView) itemView.findViewById(R.id.emp_title);
            v_nic = (TextView) itemView.findViewById(R.id.emp_nic);
            v_phone = (TextView) itemView.findViewById(R.id.emp_tel);
            V_desig  =(TextView)itemView.findViewById(R.id.emp_typ);
            v_pic  =(CircleImageView) itemView.findViewById(R.id.proit);
            vEEmail = (TextView) itemView.findViewById(R.id.emp_email);
            V_empID = (TextView)itemView.findViewById(R.id.emp_UID);
            sendMessaAc = (ImageView)itemView.findViewById(R.id.message_userID);
            //vaddress = (TextView) itemView.findViewById(R.id.rate);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    int getItem(int id) {
        return mData.size();
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}