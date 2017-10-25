package com.example.minan.asign;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

        bLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                final String uname = etUNameL.getText().toString();
                final String password = etPasswordL.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String fname = jsonResponse.getString("fname");
                                String lname = jsonResponse.getString("lname");

                                String uname = jsonResponse.getString("uname");
                                String password = jsonResponse.getString("password");

                                String email = jsonResponse.getString("email");
                                String phonenumber = jsonResponse.getString("pnumber");

                                Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);

                                intent.putExtra("fname", fname);
                                intent.putExtra("lname", lname);

                                intent.putExtra("uname", uname);
                                intent.putExtra("password", password);

                                intent.putExtra("email", email);
                                intent.putExtra("phonenumber", phonenumber);

                                LoginActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(uname,password,responseListener);

                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

                queue.add(loginRequest);
            }
        });
    }
}
