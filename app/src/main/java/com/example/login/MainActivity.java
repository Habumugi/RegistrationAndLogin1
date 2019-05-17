package com.example.login;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb ;
    EditText username;
    EditText password;
    Button Login;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new  DatabaseHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Login = findViewById(R.id.Login);
        Register = findViewById(R.id.Register);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = username.getText().toString();
                String Pass = password.getText().toString();
                if (User.equals("") || Pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "enter your Username and Password", Toast.LENGTH_LONG).show();
                } else if (User.equals("florien") && Pass.equals("12345")) {
                    Toast.makeText(getApplicationContext(), "login successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Search.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "invalid Username or Password ", Toast.LENGTH_LONG).show();

                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, User_Registration.class);
                startActivity(intent);
            }
        });
    }
}
