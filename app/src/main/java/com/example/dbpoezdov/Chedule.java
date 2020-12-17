package com.example.dbpoezdov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.view.View;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;


public class Chedule extends AppCompatActivity {

    RecyclerView recyclerViewChed;
    //TextView header4;
    MyDatabaseHelper myDB;
    //TextView ChDay_txt, ChTrain_txt1, ChMarshrut_txt1, ChPribil_txt1, ChYedet_txt1, ChWay_txt1, ChPlatform_txt1;

    ArrayList<String> ChID, ChTrain, ChMarshrut, ChDay1, ChPribil, ChYedet, ChWay, ChPlatform;

    CustomAdapter4 customAdapter4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chedule);

        recyclerViewChed = findViewById(R.id.recyclerViewChed);
        //header4 = findViewById(R.id.header4);



        myDB = new MyDatabaseHelper(Chedule.this);
        ChID = new ArrayList<>();
        ChTrain = new ArrayList<>();
        ChDay1 = new ArrayList<>();
        ChMarshrut = new ArrayList<>();
        ChPribil = new ArrayList<>();
        ChYedet = new ArrayList<>();
        ChWay = new ArrayList<>();
        ChPlatform = new ArrayList<>();

        /*Day = findViewById(R.id.ChTextDay);
        IDay = Integer.valueOf(Day.getText().toString().trim());
        if (mDay == IDay)
        {

        }*/


        storeDataInArrays();

        customAdapter4 = new CustomAdapter4(Chedule.this,this, ChID, ChTrain, ChMarshrut, ChDay1, ChPribil, ChYedet, ChWay, ChPlatform);
        recyclerViewChed.setAdapter(customAdapter4);
        recyclerViewChed.setLayoutManager(new LinearLayoutManager(Chedule.this));
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllDataCHED();
        if(cursor.getCount() == 0){
            //header4.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                ChID.add(cursor.getString(0));
                ChTrain.add(cursor.getString(1));
                ChMarshrut.add(cursor.getString(2));
                ChDay1.add(cursor.getString(3));
                ChPribil.add(cursor.getString(4));
                ChYedet.add(cursor.getString(5));
                ChWay.add(cursor.getString(6));
                ChPlatform.add(cursor.getString(7));
            }
            //header4.setVisibility(View.GONE);
        }
    }
    public void goBack(View view) {
        Intent intent = new Intent(Chedule.this, MainActivity.class);
        startActivity(intent);
    }


}