package com.example.minan.asign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText etFName = (EditText) findViewById(R.id.etFName);
        final EditText etLName = (EditText) findViewById(R.id.etLName);
        final EditText etUNameR = (EditText) findViewById(R.id.etUNameR);
        final EditText etPassword = (EditText) findViewById(R.id.etPasswordR);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPNumber = (EditText) findViewById(R.id.etPNumber);

        final Button bRegisterR = (Button) findViewById(R.id.bRegisterR);
    }
}
