package com.example.minan.asign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddWorkActivity extends AppCompatActivity {

    private void handleaddClick() {
        Intent intent = new Intent(AddWorkActivity.this, UserAreaActivity.class);
        AddWorkActivity.this.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);

        Button button = (Button)findViewById(R.id.badd);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleaddClick();
            }
        });
    }
}
