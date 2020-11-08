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

public class ViewChedule extends AppCompatActivity {

    RecyclerView recyclerView3;
    TextView header4;
    MyDatabaseHelper myDB;

    ArrayList<String> ChID, ChTrain, ChMarshrut, ChDay, ChPribil, ChYedet, ChWay, ChPlatform, ChVagonov, ChMest;

    CustomAdapter3 customAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_chedule);

        recyclerView3 = findViewById(R.id.recyclerView3);
        header4 = findViewById(R.id.header4);

        myDB = new MyDatabaseHelper(ViewChedule.this);
        ChID = new ArrayList<>();
        ChTrain = new ArrayList<>();
        ChMarshrut = new ArrayList<>();
        ChDay = new ArrayList<>();
        ChPribil = new ArrayList<>();
        ChYedet = new ArrayList<>();
        ChWay = new ArrayList<>();
        ChPlatform = new ArrayList<>();
        ChVagonov = new ArrayList<>();
        ChMest = new ArrayList<>();


        storeDataInArrays();

        customAdapter3 = new CustomAdapter3(ViewChedule.this,this, ChID, ChTrain, ChMarshrut, ChDay, ChPribil, ChYedet, ChWay, ChPlatform, ChVagonov, ChMest);
        recyclerView3.setAdapter(customAdapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(ViewChedule.this));

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllDataCHED();
        if(cursor.getCount() == 0){
            header4.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                ChID.add(cursor.getString(0));
                ChTrain.add(cursor.getString(1));
                ChMarshrut.add(cursor.getString(2));
                ChDay.add(cursor.getString(3));
                ChPribil.add(cursor.getString(4));
                ChYedet.add(cursor.getString(5));
                ChWay.add(cursor.getString(6));
                ChPlatform.add(cursor.getString(7));
                ChVagonov.add(cursor.getString(8));
                ChMest.add(cursor.getString(9));

            }
            header4.setVisibility(View.GONE);
        }
    }
}