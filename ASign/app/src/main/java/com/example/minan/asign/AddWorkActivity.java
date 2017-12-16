package com.example.minan.asign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddWorkActivity extends AppCompatActivity {

    private void handleaddClick() {
        Intent intent = new Intent(AddWorkActivity.this, UserAreaActivity.class);

        final EditText etWorkName = (EditText) findViewById(R.id.etWorkName);
        final EditText etCourse = (EditText) findViewById(R.id.etCourse);
        final EditText etNotes = (EditText) findViewById(R.id.etAddNotes);

        String name = etWorkName.getText().toString();
        String course = etCourse.getText().toString();
        String notes = etNotes.getText().toString();
        String from_where = "addActivity";

        intent.putExtra("workName" , name);
        intent.putExtra("course", course);
        intent.putExtra("notes", notes);
        intent.putExtra("where", from_where);

        //MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        //Events events = new Events(etWorkName.getText().toString(), etCourse.getText().toString());
        //dbHandler.addEvent(events);


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
