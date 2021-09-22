package com.example.restvolleyapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class adapter extends RecyclerView.Adapter<adapter.UserView> {


    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter,parent,false);
        //view holds layout for each item in arrayList
        UserView viewHolder=new UserView(view);   //passing our view to the viewHolder
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

     class UserView extends RecyclerView.ViewHolder {
        public UserView(@NonNull View itemView) {
            super(itemView);
        }
    }
}