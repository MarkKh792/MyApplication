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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList RegID, RegTicket, WagonClass, TrainNumb, Prevel, Price;

    CustomAdapter(Activity activity, Context context, ArrayList RegID, ArrayList RegTicket, ArrayList WagonClass, ArrayList TrainNumb, ArrayList Prevel, ArrayList Price){
        this.activity = activity;
        this.context = context;
        this.RegID = RegID;
        this.RegTicket = RegTicket;
        this.WagonClass = WagonClass;
        this.TrainNumb = TrainNumb;
        this.Prevel = Prevel;
        this.Price = Price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.reg_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.RegID_txt.setText(String.valueOf(RegID.get(position)));
        holder.RegTicket_txt.setText(String.valueOf(RegTicket.get(position)));
        holder.WagonClass_txt.setText(String.valueOf(WagonClass.get(position)));
        holder.TrainNumb_txt.setText(String.valueOf(TrainNumb.get(position)));
        holder.Prevel_txt.setText(String.valueOf(Prevel.get(position)));
        holder.Price_txt.setText(String.valueOf(Price.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateReg.class);
                intent.putExtra("IDReg", String.valueOf(RegID.get(position)));
                intent.putExtra("RegNum", String.valueOf(RegTicket.get(position)));
                intent.putExtra("RegClass", String.valueOf(WagonClass.get(position)));
                intent.putExtra("RegTrn", String.valueOf(TrainNumb.get(position)));
                intent.putExtra("RegPrv", String.valueOf(Prevel.get(position)));
                intent.putExtra("RegPrc", String.valueOf(Price.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return RegID.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView RegID_txt, RegTicket_txt, WagonClass_txt, TrainNumb_txt, Prevel_txt, Price_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            RegID_txt = itemView.findViewById(R.id.RegID_txt);
            RegTicket_txt = itemView.findViewById(R.id.RegTicket_txt);
            WagonClass_txt = itemView.findViewById(R.id.WagonClass_txt);
            TrainNumb_txt = itemView.findViewById(R.id.TrainNumb_txt);
            Prevel_txt = itemView.findViewById(R.id.Prevel_txt);
            Price_txt = itemView.findViewById(R.id.Price_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }

}
