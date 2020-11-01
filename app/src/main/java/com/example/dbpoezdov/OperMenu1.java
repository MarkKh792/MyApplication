package com.example.dbpoezdov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OperMenu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oper_menu1);
    }
    public void CreateChedule(View view){
        Intent intent = new Intent(OperMenu1.this, OperChedule.class);
        startActivity(intent);
    }
    public void AddCargoTrain(View view){
        Intent intent = new Intent(OperMenu1.this, AddCargoTrains.class);
        startActivity(intent);
    }
}