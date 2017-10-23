package com.example.minan.asign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final EditText etUNameL = (EditText) findViewById(R.id.etUNameL);
        final EditText etPasswordL = (EditText) findViewById(R.id.etPasswordL);

        final TextView showUName = (TextView) findViewById(R.id.tvUserName);
        final TextView showPassword = (TextView) findViewById(R.id.tvPassword);
    }
}
