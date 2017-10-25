package com.example.minan.asign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final TextView showFName = (TextView) findViewById(R.id.tvFName);
        final TextView showLName = (TextView) findViewById(R.id.tvLName);

        final TextView showUName = (TextView) findViewById(R.id.tvUserName);
        final TextView showPassword = (TextView) findViewById(R.id.tvPassword);

        final TextView showEmail = (TextView) findViewById(R.id.tvEmail);
        final TextView showPNumber = (TextView) findViewById(R.id.nvPNumber);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname");
        String lname = intent.getStringExtra("lname");

        String uname = intent.getStringExtra("uname");
        String password = intent.getStringExtra("fname");

        String email = intent.getStringExtra("email");
        String pnumber = intent.getStringExtra("pnumber");

        int phonenumber = Integer.parseInt(pnumber);
        showFName.setText(fname);
        showLName.setText(lname);

        showUName.setText(uname);
        showPassword.setText(password);

        showEmail.setText(email);
        showPNumber.setText(phonenumber);

    }
}
