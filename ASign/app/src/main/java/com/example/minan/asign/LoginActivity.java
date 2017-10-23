package com.example.minan.asign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUNameL = (EditText) findViewById(R.id.etUNameL);
        final EditText etPasswordL = (EditText) findViewById(R.id.etPasswordL);

        final Button bLogIn = (Button) findViewById(R.id.bLogin);
        final Button bRegisterL = (Button) findViewById(R.id.bRegisterL);

        bRegisterL.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

    }
}
