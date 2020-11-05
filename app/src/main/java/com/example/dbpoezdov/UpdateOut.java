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

public class UpdateOut extends AppCompatActivity {

    EditText UPPersonName1, UPPersonName21, UPPersonName31, UPPassport1, UPTrainOutside1, UPTicketOutside1, UPWagonClass1, UPWagon1, UPSeat1, UPPriceOut1;
    Button UPOut, DeleteOut;

    String name1, name2, name3, Passp, Train, Ticket, Class, NumWag, OutSeat, OutPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_out);

        UPPersonName1 = findViewById(R.id.UPPersonName);
        UPPersonName21 = findViewById(R.id.UPPersonName2);
        UPPersonName31 = findViewById(R.id.UPPersonName3);
        UPPassport1 = findViewById(R.id.UPPassport);
        UPTrainOutside1 = findViewById(R.id.UPTrainOutside);
        UPTicketOutside1 = findViewById(R.id.UPTicketOutside);
        UPWagonClass1 = findViewById(R.id.UPWagonClass);
        UPWagon1 = findViewById(R.id.UPWagon);
        UPSeat1 = findViewById(R.id.UPSeat);
        UPPriceOut1 = findViewById(R.id.UPPriceOut);
        UPOut = findViewById(R.id.UPOut);
        DeleteOut = findViewById(R.id.DeleteOut);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(Ticket);
        }

        UPOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateOut.this);
                name1 = UPPersonName1.getText().toString().trim();
                name2 = UPPersonName21.getText().toString().trim();
                name3 = UPPersonName31.getText().toString().trim();
                Passp = UPPassport1.getText().toString().trim();
                Train = UPTrainOutside1.getText().toString().trim();
                Ticket = UPTicketOutside1.getText().toString().trim();
                Class = UPWagonClass1.getText().toString().trim();
                NumWag = UPWagon1.getText().toString().trim();
                OutSeat = UPSeat1.getText().toString().trim();
                OutPrice = UPPriceOut1.getText().toString().trim();
                myDB.updateOutData(name1, name2, name3, Passp, Train, Ticket, Class, NumWag, OutSeat, OutPrice);
            }
        });
        DeleteOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("name1") && getIntent().hasExtra("name2") &&
                getIntent().hasExtra("name3") && getIntent().hasExtra("Passp")&&
                getIntent().hasExtra("Train")&& getIntent().hasExtra("Ticket")&&
                getIntent().hasExtra("Class")&& getIntent().hasExtra("NumWag")&&
                getIntent().hasExtra("OutSeat")&& getIntent().hasExtra("OutPrice")){
            //Getting Data from Intent
            name1 = getIntent().getStringExtra("name1");
            name2 = getIntent().getStringExtra("name2");
            name3 = getIntent().getStringExtra("name3");
            Passp = getIntent().getStringExtra("Passp");
            Train = getIntent().getStringExtra("Train");
            Ticket = getIntent().getStringExtra("Ticket");
            Class = getIntent().getStringExtra("Class");
            NumWag = getIntent().getStringExtra("NumWag");
            OutSeat = getIntent().getStringExtra("OutSeat");
            OutPrice = getIntent().getStringExtra("OutPrice");

            //Setting Intent Data
            UPPersonName1.setText(name1);
            UPPersonName21.setText(name2);
            UPPersonName31.setText(name3);
            UPPassport1.setText(Passp);
            UPTrainOutside1.setText(Train);
            UPTicketOutside1.setText(Ticket);
            UPWagonClass1.setText(Class);
            UPWagon1.setText(NumWag);
            UPSeat1.setText(OutSeat);
            UPPriceOut1.setText(OutPrice);
            Log.d("stev", name1+" "+name2+" "+name3+" "+Passp+" "+Train+" "+Ticket+" "+Class+" "+NumWag+" "+OutSeat+" "+OutPrice);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удалить билет" + Ticket + " ?");
        builder.setMessage("Вы действительно хотите удалить заказ " + Ticket + " ?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateOut.this);
                myDB.deleteOneOutRow(Ticket);
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