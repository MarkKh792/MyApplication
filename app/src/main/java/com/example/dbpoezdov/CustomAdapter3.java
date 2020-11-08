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

public class CustomAdapter3 extends RecyclerView.Adapter<CustomAdapter3.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList ChID, ChTrain, ChMarshrut, ChDay, ChPribil, ChYedet, ChWay, ChPlatform, ChVagonov, ChMest;

    CustomAdapter3(Activity activity, Context context, ArrayList ChID, ArrayList ChTrain, ArrayList ChMarshrut, ArrayList ChDay,
                   ArrayList ChPribil, ArrayList ChYedet, ArrayList ChWay, ArrayList ChPlatform, ArrayList ChVagonov, ArrayList ChMest){
        this.activity = activity;
        this.context = context;
        this.ChID = ChID;
        this.ChTrain = ChTrain;
        this.ChMarshrut = ChMarshrut;
        this.ChDay = ChDay;
        this.ChPribil = ChPribil;
        this.ChYedet = ChYedet;
        this.ChWay =ChWay;
        this.ChPlatform = ChPlatform;
        this.ChVagonov = ChVagonov;
        this.ChMest = ChMest;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ched_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.ChID_txt.setText(String.valueOf(ChID.get(position)));
        holder.ChTrain_txt.setText(String.valueOf(ChTrain.get(position)));
        holder.ChMarshrut_txt.setText(String.valueOf(ChMarshrut.get(position)));
        holder.ChDay_txt.setText(String.valueOf(ChDay.get(position)));
        holder.ChPribil_txt.setText(String.valueOf(ChPribil.get(position)));
        holder.ChYedet_txt.setText(String.valueOf(ChYedet.get(position)));
        holder.ChWay_txt.setText(String.valueOf(ChWay.get(position)));
        holder.ChPlatform_txt.setText(String.valueOf(ChPlatform.get(position)));
        holder.ChVagonov_txt.setText(String.valueOf(ChVagonov.get(position)));
        holder.ChMest_txt.setText(String.valueOf(ChMest.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateChed.class);                             //UpdateChed
                intent.putExtra("IDCh", String.valueOf(ChID.get(position)));
                intent.putExtra("TrainCh", String.valueOf(ChTrain.get(position)));
                intent.putExtra("WayCh", String.valueOf(ChMarshrut.get(position)));
                intent.putExtra("DayCh", String.valueOf(ChDay.get(position)));
                intent.putExtra("PribilCh", String.valueOf(ChPribil.get(position)));
                intent.putExtra("YedetCh", String.valueOf(ChYedet.get(position)));
                intent.putExtra("PutCh", String.valueOf(ChWay.get(position)));
                intent.putExtra("PlatformCh", String.valueOf(ChPlatform.get(position)));
                intent.putExtra("VagonCh", String.valueOf(ChVagonov.get(position)));
                intent.putExtra("MestCh", String.valueOf(ChMest.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return ChID.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ChID_txt, ChTrain_txt, ChMarshrut_txt, ChDay_txt, ChPribil_txt,ChYedet_txt, ChWay_txt, ChPlatform_txt, ChVagonov_txt, ChMest_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ChID_txt= itemView.findViewById(R.id.ChID_txt);
            ChTrain_txt = itemView.findViewById(R.id.ChTrain_txt);
            ChMarshrut_txt = itemView.findViewById(R.id.ChMarshrut_txt);
            ChDay_txt = itemView.findViewById(R.id.ChDay_txt);
            ChPribil_txt = itemView.findViewById(R.id.ChPribil_txt);
            ChYedet_txt = itemView.findViewById(R.id.ChYedet_txt);
            ChWay_txt = itemView.findViewById(R.id.ChWay_txt);
            ChPlatform_txt = itemView.findViewById(R.id.ChPlatform_txt);
            ChVagonov_txt = itemView.findViewById(R.id.ChVagonov_txt);
            ChMest_txt = itemView.findViewById(R.id.ChMest_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }

}
