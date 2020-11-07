package com.example.dbpoezdov;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewOutsideTicket extends AppCompatActivity {
    EditText  TicketOutside, PersonName, PersonName2, PersonName3, Passport, TrainOutside, WagonClass, Wagon, Seat, Price;
    Button add_Out;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_outside_ticket);

        TicketOutside = findViewById(R.id.TicketOutside);
        PersonName = findViewById(R.id.PersonName);
        PersonName2 = findViewById(R.id.PersonName2);
        PersonName3 = findViewById(R.id.PersonName3);
        Passport = findViewById(R.id.Passport);
        TrainOutside = findViewById(R.id.TrainOutside);

        WagonClass = findViewById(R.id.WagonClass);
        Wagon = findViewById(R.id.Wagon);
        Seat = findViewById(R.id.Seat);
        Price = findViewById(R.id.PriceOut);
        add_Out = findViewById(R.id.add_Out);
        add_Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(NewOutsideTicket.this);
                myDB.addOutinfo(TicketOutside.getText().toString().trim(),
                        PersonName.getText().toString().trim(),
                        PersonName2.getText().toString().trim(),
                        PersonName3.getText().toString().trim(),
                        Passport.getText().toString().trim(),
                        TrainOutside.getText().toString().trim(),

                        WagonClass.getText().toString().trim(),
                        Integer.valueOf(Wagon.getText().toString().trim()),
                        Integer.valueOf(Seat.getText().toString().trim()),
                        Integer.valueOf(Price.getText().toString().trim()));
            }
        });
    }

    public void ViewOut(View view) {
        Intent intent = new Intent(NewOutsideTicket.this, ViewTickets2.class);
        startActivity(intent);
    }
}
    /*Button button10;
    EditText FName, Lname, Sname, NPass, TraiN, NOutTicket, WagClass, NWag, Seat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_outside_ticket);
        db = new NewDatabase(this);
        FName = (EditText) findViewById(R.id.PersonName);
        Lname = (EditText) findViewById(R.id.PersonName2);
        Sname = (EditText) findViewById(R.id.PersonName3);
        NPass = (EditText) findViewById(R.id.Passport);
        TraiN = (EditText) findViewById(R.id.TrainOutside);
        NOutTicket = (EditText) findViewById(R.id.TicketOutside);
        WagClass = (EditText) findViewById(R.id.WagonClass);
        NWag = (EditText) findViewById(R.id.Wagon);
        Seat = (EditText) findViewById(R.id.Seat);

        button10 = (Button) findViewById(R.id.button10);
        onLogin();
    }

    public void onLogin() {
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = UserName.getText().toString();
                String passw = Password.getText().toString();

                Boolean ChkUserPassw = db.userpassw(username, passw);

                if (ChkUserPassw == true) {
                    Toast.makeText(getApplicationContext(), "Добро пожаловать", Toast.LENGTH_SHORT).show();
                    if (username.equals("operator")) {
                        Intent intent = new Intent(MainActivity.this, OperMenu1.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(NewOutsideTicket.this, Menu.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Неверное имя или пароль", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }*/