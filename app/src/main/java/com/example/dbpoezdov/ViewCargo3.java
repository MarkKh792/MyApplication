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

public class ViewCargo3 extends AppCompatActivity {

    RecyclerView recyclerView3;
    TextView header3;
    MyDatabaseHelper myDB;

    ArrayList<String> caID, caTrain, caMarshrut, caDay, caPribil, caYedet, cargo, weight, caPrice, caVagonov, add, addnt;

    CustomAdapter2 customAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cargo3);

        recyclerView3 = findViewById(R.id.recyclerView2);
        header3 = findViewById(R.id.header3);

        myDB = new MyDatabaseHelper(ViewCargo3.this);
        caID = new ArrayList<>();
        caTrain = new ArrayList<>();
        caMarshrut = new ArrayList<>();
        caDay = new ArrayList<>();
        caPribil = new ArrayList<>();
        caYedet = new ArrayList<>();
        cargo = new ArrayList<>();
        weight = new ArrayList<>();
        caPrice = new ArrayList<>();
        caVagonov = new ArrayList<>();
        add = new ArrayList<>();
        addnt = new ArrayList<>();

        storeDataInArrays();

        customAdapter2 = new CustomAdapter2(ViewCargo3.this,this, caID, caTrain, caMarshrut, caDay, caPribil, caYedet, cargo, weight, caPrice, caVagonov, add, addnt);
        recyclerView3.setAdapter(customAdapter2);
        recyclerView3.setLayoutManager(new LinearLayoutManager(ViewCargo3.this));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllDataCARGO();   //ВНИМАНИЕ НА readAll---
        if(cursor.getCount() == 0){
            header3.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                caID.add(cursor.getString(0));
                caTrain.add(cursor.getString(1));
                caMarshrut.add(cursor.getString(2));
                caDay.add(cursor.getString(3));
                caPribil.add(cursor.getString(4));
                caYedet.add(cursor.getString(5));
                cargo.add(cursor.getString(6));
                weight.add(cursor.getString(7));
                caPrice.add(cursor.getString(8));
                caVagonov.add(cursor.getString(9));
                add.add(cursor.getString(10));
                addnt.add(cursor.getString(11));
            }
            header3.setVisibility(View.GONE);
        }
    }
}