package com.example.dbpoezdov;

import androidx.annotation.Nullable;
import android.content.Intent;
import android.os.Bundle;
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

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewInsideTicket extends AppCompatActivity {
    EditText RegID_input, classREG_input, TrainREG_input, Prev_input, REGPrice_input;
    Button add_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_inside_ticket);

        RegID_input = findViewById(R.id.RegID_input);
        classREG_input = findViewById(R.id.classREG_input);
        TrainREG_input = findViewById(R.id.PreveligyREG_input);
        Prev_input = findViewById(R.id.Prev_input);
        REGPrice_input = findViewById(R.id.REGPrice_input);

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(NewInsideTicket.this);
                myDB.addREGinfo(RegID_input.getText().toString().trim(),
                                classREG_input.getText().toString().trim(),
                                TrainREG_input.getText().toString().trim(),
                                Prev_input.getText().toString().trim(),
                                Integer.valueOf(REGPrice_input.getText().toString().trim()));
            }
        });

    }

    public void ViewReg(View view) {
        Intent intent = new Intent(NewInsideTicket.this, ViewTickets1.class);
        startActivity(intent);
    }
}