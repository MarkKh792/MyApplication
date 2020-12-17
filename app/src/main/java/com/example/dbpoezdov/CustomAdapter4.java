package com.example.dbpoezdov;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter4 extends RecyclerView.Adapter<CustomAdapter4.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList ChID, ChTrain, ChMarshrut, ChDay1, ChPribil, ChYedet, ChWay, ChPlatform;

    CustomAdapter4(Activity activity, Context context, ArrayList ChID, ArrayList ChTrain, ArrayList ChMarshrut, ArrayList ChDay1,
                      ArrayList ChPribil, ArrayList ChYedet, ArrayList ChWay, ArrayList ChPlatform) {
        this.activity = activity;
        this.context = context;
        this.ChID = ChID;
        this.ChDay1 = ChDay1;
        this.ChTrain = ChTrain;
        this.ChMarshrut = ChMarshrut;
        this.ChPribil = ChPribil;
        this.ChYedet = ChYedet;
        this.ChWay = ChWay;
        this.ChPlatform = ChPlatform;
    }

    @NonNull
    @Override
    public CustomAdapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.calendar_row, parent, false);
        return new CustomAdapter4.MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final CustomAdapter4.MyViewHolder holder, final int position) {
        holder.ChID_txt1.setText(String.valueOf(ChID.get(position)));
        holder.ChTrain_txt1.setText(String.valueOf(ChTrain.get(position)));
        holder.ChMarshrut_txt1.setText(String.valueOf(ChMarshrut.get(position)));
        holder.ChDay_txt1.setText(String.valueOf(ChDay1.get(position)));
        holder.ChPribil_txt1.setText(String.valueOf(ChPribil.get(position)));
        holder.ChYedet_txt1.setText(String.valueOf(ChYedet.get(position)));
        holder.ChWay_txt1.setText(String.valueOf(ChWay.get(position)));
        holder.ChPlatform_txt1.setText(String.valueOf(ChPlatform.get(position)));
        //Recyclerview onClickListener
    }
    @Override
    public int getItemCount() {
        return ChID.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ChID_txt1, ChTrain_txt1, ChMarshrut_txt1, ChDay_txt1, ChPribil_txt1, ChYedet_txt1, ChWay_txt1, ChPlatform_txt1;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ChID_txt1= itemView.findViewById(R.id.ChID_txt1);
            ChTrain_txt1 = itemView.findViewById(R.id.ChTrain_txt1);
            ChMarshrut_txt1 = itemView.findViewById(R.id.ChMarshrut_txt1);
            ChDay_txt1 = itemView.findViewById(R.id.ChDay_txt1);
            ChPribil_txt1 = itemView.findViewById(R.id.ChPribil_txt1);
            ChYedet_txt1 = itemView.findViewById(R.id.ChYedet_txt1);
            ChWay_txt1 = itemView.findViewById(R.id.ChWay_txt1);
            ChPlatform_txt1 = itemView.findViewById(R.id.ChPlatform_txt1);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }
}