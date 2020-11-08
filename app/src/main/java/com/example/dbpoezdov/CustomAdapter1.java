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

public class CustomAdapter1 extends RecyclerView.Adapter<CustomAdapter1.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList  OutID, NOutTicket, Fname, Lname, Sname, NPass, TraiN, WagClass, NWag, Seat, PriceOut;

    CustomAdapter1(Activity activity, Context context, ArrayList OutID, ArrayList NOutTicket, ArrayList Fname, ArrayList Lname, ArrayList Sname, ArrayList NPass, ArrayList TraiN, ArrayList WagClass, ArrayList NWag, ArrayList Seat, ArrayList PriceOut){
        this.activity = activity;
        this.context = context;
        this.OutID = OutID;
        this.NOutTicket = NOutTicket;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Sname = Sname;
        this.NPass = NPass;
        this.TraiN = TraiN;
        this.WagClass = WagClass;
        this.NWag = NWag;
        this.Seat =  Seat;
        this.PriceOut = PriceOut;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.out_row1, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.OutID_txt.setText(String.valueOf(OutID.get(position)));
        holder.text_NOutTicket.setText(String.valueOf(NOutTicket.get(position)));
        holder.text_Fname.setText(String.valueOf(Fname.get(position)));
        holder.text_Lname.setText(String.valueOf(Lname.get(position)));
        holder.text_Sname.setText(String.valueOf(Sname.get(position)));
        holder.text_NPass.setText(String.valueOf(NPass.get(position)));
        holder.text_TraiN.setText(String.valueOf(TraiN.get(position)));
        holder.text_WagClass.setText(String.valueOf(WagClass.get(position)));
        holder.text_NWag.setText(String.valueOf(NWag.get(position)));
        holder.text_Seat.setText(String.valueOf(Seat.get(position)));
        holder.text_PriceOut.setText(String.valueOf(PriceOut.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateOut.class);
                intent.putExtra("IDOut", String.valueOf(OutID.get(position)));
                intent.putExtra("Ticket", String.valueOf(NOutTicket.get(position)));
                intent.putExtra("name1", String.valueOf(Fname.get(position)));
                intent.putExtra("name2", String.valueOf(Lname.get(position)));
                intent.putExtra("name3", String.valueOf(Sname.get(position)));
                intent.putExtra("Passp", String.valueOf(NPass.get(position)));
                intent.putExtra("Train", String.valueOf(TraiN.get(position)));
                intent.putExtra("Class", String.valueOf(WagClass.get(position)));
                intent.putExtra("NumWag", String.valueOf(NWag.get(position)));
                intent.putExtra("OutSeat", String.valueOf(Seat.get(position)));
                intent.putExtra("OutPrice", String.valueOf(PriceOut.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return OutID.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView OutID_txt, text_NOutTicket, text_Fname, text_Lname, text_Sname, text_NPass, text_TraiN, text_WagClass, text_NWag, text_Seat, text_PriceOut;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            OutID_txt = itemView.findViewById(R.id.OutID_txt);
            text_NOutTicket = itemView.findViewById(R.id.text_NOutTicket);
            text_Fname = itemView.findViewById(R.id.text_Fname);
            text_Lname = itemView.findViewById(R.id.text_Lname);
            text_Sname = itemView.findViewById(R.id.text_Sname);
            text_NPass = itemView.findViewById(R.id.text_NPass);
            text_TraiN = itemView.findViewById(R.id.text_TraiN);
            text_WagClass = itemView.findViewById(R.id.text_WagClass);
            text_NWag = itemView.findViewById(R.id.text_NWag);
            text_Seat = itemView.findViewById(R.id.text_Seat);
            text_PriceOut = itemView.findViewById(R.id.text_PriceOut);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }

}