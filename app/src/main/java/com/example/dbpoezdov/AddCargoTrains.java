package com.example.dbpoezdov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCargoTrains extends AppCompatActivity {
    EditText CaTrain, CaMarshrut, CaDay, CaPribil, CaYedet, Cargo, Weight, CaPrice, Add, Addnt;
    Button add_CaTrain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cargo_trains);

        CaTrain = findViewById(R.id.CaTrain);
        CaMarshrut = findViewById(R.id.CaMarshrut);
        CaDay = findViewById(R.id.CaDay);
        CaPribil = findViewById(R.id.CaPribil);
        CaYedet = findViewById(R.id.CaYedet);
        Cargo = findViewById(R.id.Cargo);
        Weight = findViewById(R.id.Weight);
        CaPrice = findViewById(R.id.CaPrice);
        Add = findViewById(R.id.Add);
        Addnt = findViewById(R.id.Addnt);
        add_CaTrain = findViewById(R.id.add_CaTrain);
        add_CaTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddCargoTrains.this);
                myDB.addCargoinfo(CaTrain.getText().toString().trim(),
                        CaMarshrut.getText().toString().trim(),
                        Integer.valueOf(CaDay.getText().toString().trim()),
                        CaPribil.getText().toString().trim(),
                        CaYedet.getText().toString().trim(),
                        Cargo.getText().toString().trim(),
                        Integer.valueOf(Weight.getText().toString().trim()),
                        Integer.valueOf(CaPrice.getText().toString().trim()),
                        Integer.valueOf(Add.getText().toString().trim()),
                        Integer.valueOf(Addnt.getText().toString().trim()));
            }
        });
    }}