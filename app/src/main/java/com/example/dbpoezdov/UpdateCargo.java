package com.example.dbpoezdov;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCargo extends AppCompatActivity {

    EditText caTrain_input1, caMarshrut_input1, caDay_input1, caPribil_input1, caYedet_input1, cargo_input1, weight_input1, caPrice_input1, add_input1, addnt_input1;
    Button updateCargo_button, deleteCargo_button;

    String IDCa, TrainCa, WayCa, DayCa, PribilCa, YedetCa, CargoCa, WeightCa, PriceCa, AddCa, AddntCa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cargo);

        caTrain_input1 = findViewById(R.id.caTrain_input);
        caMarshrut_input1 = findViewById(R.id.caMarshrut_input);
        caDay_input1 = findViewById(R.id.caDay_input);
        caPribil_input1 = findViewById(R.id.caPribil_input);
        caYedet_input1 = findViewById(R.id.caYedet_input);
        cargo_input1 = findViewById(R.id.cargo_input);
        weight_input1 = findViewById(R.id.weight_input);
        caPrice_input1 = findViewById(R.id.caPrice_input);
        add_input1 = findViewById(R.id.add_input);
        addnt_input1 = findViewById(R.id.addnt_input);
        updateCargo_button = findViewById(R.id.updateCargo_button);
        deleteCargo_button = findViewById(R.id.deleteCargo_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(TrainCa);
        }

        updateCargo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateCargo.this);
                TrainCa = caTrain_input1.getText().toString().trim();
                WayCa = caMarshrut_input1.getText().toString().trim();
                DayCa = caDay_input1.getText().toString().trim();
                PribilCa = caPribil_input1.getText().toString().trim();
                YedetCa = caYedet_input1.getText().toString().trim();
                CargoCa = cargo_input1.getText().toString().trim();
                WeightCa = weight_input1.getText().toString().trim();
                PriceCa = caPrice_input1.getText().toString().trim();
                AddCa = add_input1.getText().toString().trim();
                AddntCa = addnt_input1.getText().toString().trim();
                myDB.updateCargoData(IDCa, TrainCa, WayCa, DayCa, PribilCa, YedetCa, CargoCa, WeightCa, PriceCa, AddCa, AddntCa);
            }
        });
        deleteCargo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("IDCa") && getIntent().hasExtra("TrainCa") && getIntent().hasExtra("WayCa") &&
                getIntent().hasExtra("DayCa") && getIntent().hasExtra("PribilCa")&&
                getIntent().hasExtra("YedetCa")&& getIntent().hasExtra("CargoCa")&&
                getIntent().hasExtra("WeightCa")&& getIntent().hasExtra("PriceCa")&&
                getIntent().hasExtra("AddCa")&& getIntent().hasExtra("AddntCa")){
            //Getting Data from Intent
            IDCa = getIntent().getStringExtra("IDCa");
            TrainCa = getIntent().getStringExtra("TrainCa");
            WayCa = getIntent().getStringExtra("WayCa");
            DayCa = getIntent().getStringExtra("DayCa");
            PribilCa = getIntent().getStringExtra("PribilCa");
            YedetCa = getIntent().getStringExtra("YedetCa");
            CargoCa = getIntent().getStringExtra("CargoCa");
            WeightCa = getIntent().getStringExtra("WeightCa");
            PriceCa = getIntent().getStringExtra("PriceCa");
            AddCa = getIntent().getStringExtra("AddCa");
            AddntCa = getIntent().getStringExtra("AddntCa");

            //Setting Intent Data
            caTrain_input1.setText(TrainCa);
            caMarshrut_input1.setText(WayCa);
            caDay_input1.setText(DayCa);
            caPribil_input1.setText(PribilCa);
            caYedet_input1.setText(YedetCa);
            cargo_input1.setText(CargoCa);
            weight_input1.setText(WeightCa);
            caPrice_input1.setText(PriceCa);
            add_input1.setText(AddCa);
            addnt_input1.setText(AddntCa);
            Log.d("stev", TrainCa+" "+WayCa+" "+DayCa+" "+PribilCa+" "+YedetCa+" "+CargoCa+" "+WeightCa+" "+PriceCa+" "+AddCa+" "+AddntCa);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удаление состава " + TrainCa + " из базы данных");
        builder.setMessage("Удалить состав " + TrainCa + " ?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateCargo.this);
                myDB.deleteOneCargoRow(IDCa);
                finish();
            }
        });
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
