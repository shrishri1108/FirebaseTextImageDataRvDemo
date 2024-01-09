package com.example.firebasetextimagedatafetchingtorecyclerview.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.firebasetextimagedatafetchingtorecyclerview.FirebaseResponseModel;
import com.example.firebasetextimagedatafetchingtorecyclerview.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerDataAdapter extends FirebaseRecyclerAdapter<FirebaseResponseModel,RecyclerDataAdapter.itemviewHolder> {


    public RecyclerDataAdapter( @NonNull FirebaseRecyclerOptions<FirebaseResponseModel>  mylist) {
        super(mylist);
    }
    @NonNull
    @Override
    public itemviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent,false);
        return new itemviewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull itemviewHolder holder, int position, @NonNull FirebaseResponseModel model) {
        holder.password.setText(model.getPassword());
        holder.contactno.setText(model.getContact_no());
        holder.name.setText(model.getName());
        holder.age.setText(model.getAge());
        Glide.with(holder.user_img.getContext()).load(model.getImgLinks()).into(holder.user_img);
    }

    class itemviewHolder extends RecyclerView.ViewHolder{
        private CircleImageView user_img;
        private TextView name,contactno,password,age;
        public itemviewHolder(@NonNull View itemView) {
            super(itemView);
            user_img =(CircleImageView) itemView.findViewById(R.id.user_img);
            name= (TextView) itemView.findViewById(R.id.tv_name);
            password= (TextView) itemView.findViewById(R.id.tv_password);
            contactno= (TextView) itemView.findViewById(R.id.tv_contact_no);
            age= (TextView) itemView.findViewById(R.id.tv_age);
        }
    }
}