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

public class ViewTickets1 extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView header;
    MyDatabaseHelper myDB;

    ArrayList<String> RegID, RegTicket, WagonClass, TrainNumb, Prevel, Price;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tickets1);

        recyclerView = findViewById(R.id.recyclerView);
        header = findViewById(R.id.header);

        myDB = new MyDatabaseHelper(ViewTickets1.this);
        RegID = new ArrayList<>();
        RegTicket = new ArrayList<>();
        WagonClass = new ArrayList<>();
        TrainNumb = new ArrayList<>();
        Prevel = new ArrayList<>();
        Price = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(ViewTickets1.this,this, RegID, RegTicket, WagonClass, TrainNumb, Prevel, Price);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewTickets1.this));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllDataREG();           //ВНИМАНИЕ НА readAll---
        if(cursor.getCount() == 0){
            header.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                RegID.add(cursor.getString(0));
                RegTicket.add(cursor.getString(1));
                WagonClass.add(cursor.getString(2));
                TrainNumb.add(cursor.getString(3));
                Prevel.add(cursor.getString(4));
                Price.add(cursor.getString(5));
            }
            header.setVisibility(View.GONE);
        }
    }
}