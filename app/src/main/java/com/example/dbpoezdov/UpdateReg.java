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

public class UpdateReg extends AppCompatActivity {

    EditText UPRegNum1, UPRegClass1, UPRegTrn1, UPRregPrev1, UPRegPrice1;
    Button UpdateREG_button, DeleteREG_button;

    String IDReg, RegNum, RegClass, RegTrn, RegPrv, RegPrc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_reg);

        UPRegNum1 = findViewById(R.id.UPRegNum);
        UPRegClass1 = findViewById(R.id.UPRegClass);
        UPRegTrn1 = findViewById(R.id.UPRegTrn);
        UPRregPrev1 = findViewById(R.id.UPRegPrev);
        UPRegPrice1 = findViewById(R.id.UPRegPrice);
        UpdateREG_button = findViewById(R.id.UpdateREG_button);
        DeleteREG_button = findViewById(R.id.DeleteREG_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(RegNum);
        }

        UpdateREG_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateReg.this);
                RegNum = UPRegNum1.getText().toString().trim();
                RegClass = UPRegClass1.getText().toString().trim();
                RegTrn = UPRegTrn1.getText().toString().trim();
                RegPrv = UPRregPrev1.getText().toString().trim();
                RegPrc = UPRegPrice1.getText().toString().trim();
                myDB.updateREGdata(IDReg, RegNum, RegClass, RegTrn, RegPrv, RegPrc);
            }
        });
        DeleteREG_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("IDReg") && getIntent().hasExtra("RegNum")
                && getIntent().hasExtra("RegClass") && getIntent().hasExtra("RegTrn") &&
                getIntent().hasExtra("RegPrv") && getIntent().hasExtra("RegPrc")){
            //Getting Data from Intent
            IDReg = getIntent().getStringExtra("IDReg");
            RegNum = getIntent().getStringExtra("RegNum");
            RegClass = getIntent().getStringExtra("RegClass");
            RegTrn = getIntent().getStringExtra("RegTrn");
            RegPrv = getIntent().getStringExtra("RegPrv");
            RegPrc = getIntent().getStringExtra("RegPrc");

            //Setting Intent Data
            UPRegNum1.setText(RegNum);
            UPRegClass1.setText(RegClass);
            UPRegTrn1.setText(RegTrn);
            UPRregPrev1.setText(RegPrv);
            UPRegPrice1.setText(RegPrc);
            Log.d("stev", RegNum+" "+RegClass+" "+RegTrn+" "+RegPrv+" "+RegPrc);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удаление билета " + RegNum + " из базы данных");
        builder.setMessage("Удалить билет " + RegNum + " ?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateReg.this);
                myDB.deleteOneREGrow(IDReg);
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