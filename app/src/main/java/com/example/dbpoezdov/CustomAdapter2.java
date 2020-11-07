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

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList caTrain, caMarshrut, caDay, caPribil, caYedet, cargo, weight, caPrice, add, addnt;

    CustomAdapter2(Activity activity, Context context, ArrayList caTrain, ArrayList caMarshrut, ArrayList caDay, ArrayList caPribil, ArrayList caYedet,
    ArrayList cargo, ArrayList weight, ArrayList caPrice, ArrayList add, ArrayList addnt){
        this.activity = activity;
        this.context = context;
        this.caTrain = caTrain;
        this.caMarshrut = caMarshrut;
        this.caDay = caDay;
        this.caPribil = caPribil;
        this.caYedet = caYedet;
        this.cargo = cargo;
        this.weight = weight;
        this.caPrice = caPrice;
        this.add = add;
        this.addnt = addnt;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ca_row1, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.CaTrain_txt.setText(String.valueOf(caTrain.get(position)));
        holder.CaMarshrut_txt.setText(String.valueOf(caMarshrut.get(position)));
        holder.CaDay_txt.setText(String.valueOf(caDay.get(position)));
        holder.CaPribil_txt.setText(String.valueOf(caPribil.get(position)));
        holder.CaYedet_txt.setText(String.valueOf(caYedet.get(position)));
        holder.Cargo_txt.setText(String.valueOf(cargo.get(position)));
        holder.CaWeight_txt.setText(String.valueOf(weight.get(position)));
        holder.CaPrice_txt.setText(String.valueOf(caPrice.get(position)));
        holder.CaAdd_txt.setText(String.valueOf(add.get(position)));
        holder.CaAddnt_txt.setText(String.valueOf(addnt.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateCargo.class);
                intent.putExtra("TrainCa", String.valueOf(caTrain.get(position)));
                intent.putExtra("WayCa", String.valueOf(caMarshrut.get(position)));
                intent.putExtra("DayCa", String.valueOf(caDay.get(position)));
                intent.putExtra("PribilCa", String.valueOf(caPribil.get(position)));
                intent.putExtra("YedetCa", String.valueOf(caYedet.get(position)));
                intent.putExtra("CargoCa", String.valueOf(cargo.get(position)));
                intent.putExtra("WeightCa", String.valueOf(weight.get(position)));
                intent.putExtra("PriceCa", String.valueOf(caPrice.get(position)));
                intent.putExtra("AddCa", String.valueOf(add.get(position)));
                intent.putExtra("AddntCa", String.valueOf(addnt.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return caTrain.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView CaTrain_txt, CaMarshrut_txt, CaDay_txt, CaPribil_txt, CaYedet_txt, Cargo_txt, CaWeight_txt, CaPrice_txt, CaAdd_txt, CaAddnt_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            CaTrain_txt = itemView.findViewById(R.id.CaTrain_txt);
            CaMarshrut_txt = itemView.findViewById(R.id.CaMarshrut_txt);
            CaDay_txt = itemView.findViewById(R.id.CaDay_txt);
            CaPribil_txt = itemView.findViewById(R.id.CaPribil_txt);
            CaYedet_txt = itemView.findViewById(R.id.CaYedet_txt);
            Cargo_txt = itemView.findViewById(R.id.Cargo_txt);
            CaWeight_txt = itemView.findViewById(R.id.CaWeight_txt);
            CaPrice_txt = itemView.findViewById(R.id.CaPrice_txt);
            CaAdd_txt = itemView.findViewById(R.id.CaAdd_txt);
            CaAddnt_txt = itemView.findViewById(R.id.CaAddnt_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }

}
