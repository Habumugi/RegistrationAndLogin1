package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.login.R.layout.user__registration;

public class User_Registration extends AppCompatActivity {
    EditText username;
    EditText password;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(user__registration);
        final DatabaseHelper mydb = new DatabaseHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Register = findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted =mydb.insertdata(username.getText().toString(), password.getText().toString());
                if (isInserted=true)
                    Toast.makeText(User_Registration.this ,"data is inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(User_Registration.this ,"data is not inserted",Toast.LENGTH_LONG).show();


            }
        });


    }

}
