package com.example.dbpoezdov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    Button button5;
    EditText UserName, Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        UserName = (EditText) findViewById(R.id.Login);
        Password = (EditText) findViewById(R.id.Pass);
        button5 = (Button) findViewById(R.id.button5);
        onLogin();
    }

    public void onLogin() {
        button5.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(MainActivity.this, Menu.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Неверное имя или пароль", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this, Chedule.class);
        startActivity(intent);
    }

}
