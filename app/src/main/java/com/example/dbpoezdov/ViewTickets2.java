package com.example.dbpoezdov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;

import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.os.Bundle;

public class ViewTickets2 extends AppCompatActivity {

    RecyclerView recyclerView1;
    TextView header2;
    MyDatabaseHelper myDB;

    ArrayList<String> OutID, NOutTicket, Fname, Lname, Sname, NPass, TraiN, WagClass, NWag, Seat, PriceOut;

    CustomAdapter1 customAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tickets2);

        recyclerView1 = findViewById(R.id.recyclerView1);
        header2 = findViewById(R.id.header2);

        myDB = new MyDatabaseHelper(ViewTickets2.this);
        OutID = new ArrayList<>();
        NOutTicket = new ArrayList<>();
        Fname = new ArrayList<>();
        Lname = new ArrayList<>();
        Sname = new ArrayList<>();
        NPass = new ArrayList<>();
        TraiN = new ArrayList<>();
        WagClass = new ArrayList<>();
        NWag = new ArrayList<>();
        Seat = new ArrayList<>();
        PriceOut = new ArrayList<>();

        storeDataInArrays();

        customAdapter1 = new CustomAdapter1(ViewTickets2.this,this, OutID, NOutTicket, Fname, Lname, Sname, NPass, TraiN, WagClass, NWag, Seat, PriceOut);
        recyclerView1.setAdapter(customAdapter1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(ViewTickets2.this));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllDataOUT();   //ВНИМАНИЕ НА readAll---
        if(cursor.getCount() == 0){
            header2.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                OutID.add(cursor.getString(0));
                NOutTicket.add(cursor.getString(1));
                Fname.add(cursor.getString(2));
                Lname.add(cursor.getString(3));
                Sname.add(cursor.getString(4));
                NPass.add(cursor.getString(5));
                TraiN.add(cursor.getString(6));
                WagClass.add(cursor.getString(7));
                NWag.add(cursor.getString(8));
                Seat.add(cursor.getString(9));
                PriceOut.add(cursor.getString(10));
            }
            header2.setVisibility(View.GONE);
        }
    }
}