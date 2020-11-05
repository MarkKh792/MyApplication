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

    RecyclerView recyclerView;
    TextView header;
    MyDatabaseHelper myDB;

    ArrayList<String> NOutTicket, Fname, Lname, Sname, NPass, TraiN, WagClass, NWag, Seat, PriceOut;

    CustomAdapter1 customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tickets1);

        recyclerView = findViewById(R.id.recyclerView);
        header = findViewById(R.id.header);

        myDB = new MyDatabaseHelper(ViewTickets2.this);
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

        customAdapter = new CustomAdapter1(ViewTickets2.this,this, NOutTicket, Fname, Lname, Sname, NPass, TraiN, WagClass, NWag, Seat, PriceOut);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewTickets2.this));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllDataOUT();
        if(cursor.getCount() == 0){
            header.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                NOutTicket.add(cursor.getString(0));
                Fname.add(cursor.getString(1));
                Lname.add(cursor.getString(2));
                Sname.add(cursor.getString(3));
                NPass.add(cursor.getString(4));
                TraiN.add(cursor.getString(5));
                WagClass.add(cursor.getString(6));
                NWag.add(cursor.getString(7));
                Seat.add(cursor.getString(8));
                PriceOut.add(cursor.getString(9));
            }
            header.setVisibility(View.GONE);
        }
    }
}