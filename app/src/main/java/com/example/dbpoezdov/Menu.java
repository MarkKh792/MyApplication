package com.example.dbpoezdov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void addOutsideTicket(View view) {
        Intent intent = new Intent(Menu.this, NewOutsideTicket.class);
        startActivity(intent);
    }
    public void addInsideTicket(View view) {
        Intent intent = new Intent(Menu.this, NewInsideTicket.class);
        startActivity(intent);
    }
}
