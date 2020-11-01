package com.example.dbpoezdov;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class OperChedule extends AppCompatActivity {
    EditText ChTrain, ChSostType, ChMarshrut, ChDay, ChPribil, ChYedet, ChWay, ChPlatf, ChVagonov, ChMest;
    Button add_Ched;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oper_chedule);

        ChTrain = findViewById(R.id.ChTextTrain);
        ChSostType = findViewById(R.id.ChTextSostav);
        ChMarshrut = findViewById(R.id.ChTextMarshrut);
        ChDay = findViewById(R.id.ChTextDay);
        ChPribil = findViewById(R.id.ChTextPribil);
        ChYedet = findViewById(R.id.ChTextYedet);
        ChWay = findViewById(R.id.ChTextWay);
        ChPlatf = findViewById(R.id.ChTextPlatform);
        ChVagonov = findViewById(R.id.ChTextVagonov);
        ChMest = findViewById(R.id.ChTextMest);
        add_Ched = findViewById(R.id.addCh);
        add_Ched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(OperChedule.this);
                myDB.addCHEDinfo(ChTrain.getText().toString().trim(),
                        ChSostType.getText().toString().trim(),
                        ChMarshrut.getText().toString().trim(),
                        Integer.valueOf(ChDay.getText().toString().trim()),
                        ChPribil.getText().toString().trim(),
                        ChYedet.getText().toString().trim(),
                        Integer.valueOf(ChWay.getText().toString().trim()),
                        Integer.valueOf(ChPlatf.getText().toString().trim()),
                        Integer.valueOf(ChVagonov.getText().toString().trim()),
                        Integer.valueOf(ChMest.getText().toString().trim()));
            }
        });
    }}