package com.example.minan.asign;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserAreaActivity extends AppCompatActivity {

    public static final String PREF_FILE_NAME = "mySPfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        //Button listner to add work
        Button AddWorkButton = (Button) findViewById(R.id.baddWork);
        AddWorkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAddWorkClick();
            }
        });

        //Getting intents source
        Intent intent = getIntent();
        String id = intent.getStringExtra("where").toString().trim();

        //Creating two arraylist to pass into array adaptor
        ArrayList<String> workArray = new ArrayList<String>();
        ArrayList<String> courseArray = new ArrayList<String>();

        //If intent sourse is from the AddWorkActivity
        if(id.equals("addActivity")) {
            Toast.makeText(this,"Inside if statment", Toast.LENGTH_LONG).show();

            //Grabs the info from the intent stores them in strings
            String work = intent.getStringExtra("workName");
            String course = intent.getStringExtra("course");


            workArray.add(work);
            courseArray.add(course);

            //Attempt at loading and accesing from a db
            //MyDBHandler myDBHandler = new MyDBHandler(this, null, null, 1);
            //myDBHandler.retrieveEvents(workArray,courseArray);


            //Gett reference of listview and passing it on to array adaptor to be displayed
            ListView listView = (ListView)findViewById(R.id.llWorkList);
            WorkListAdaptor workListAdaptor = new WorkListAdaptor(this, workArray,courseArray);
            listView.setAdapter(workListAdaptor);
        }

        //loadSharedPref(workArray,courseArray);

        //saveSharedPref(workArray,courseArray);
    }

    //Attempt at Loading data (Doesnt work yet) using persistant concepts
    protected void loadSharedPref(ArrayList<String> workArray,ArrayList<String> courseArray){

        Intent intent = getIntent();
        String id = intent.getStringExtra("where").toString().trim();

        SharedPreferences sharedPreferences = getSharedPreferences(PREF_FILE_NAME, 0);

        long workId = sharedPreferences.getLong("workID0", -1);
        long courseId = sharedPreferences.getLong("courseID0", -1);
        long hold;

        if(workId == -1) {
            System.out.print("no work saved");
        }else if(courseId == -1){
            System.out.print("no courses saved");
        }else{

            int i = 0;

            do{
                workArray.add(""+workId);
                courseArray.add(""+courseId);

                workId = sharedPreferences.getLong("workID" + i, -1);
                courseId = sharedPreferences.getLong("workID" + i, -1);

                hold = sharedPreferences.getLong("workID" + i, -1);
                i++;
            }while(hold != -1);
        }

        if(id.equals("addActivity")) {
            Toast.makeText(this,"Inside if statment", Toast.LENGTH_LONG).show();

            String worktext = intent.getStringExtra("workName").toString();
            String coursetext = intent.getStringExtra("course").toString();

            ListView listView = (ListView)findViewById(R.id.llWorkList);

            WorkListAdaptor workListAdaptor = new WorkListAdaptor(this, workArray,courseArray);

            listView.setAdapter(workListAdaptor);
        }

        Toast.makeText(this,"done loading data", Toast.LENGTH_LONG).show();
    }

    //Attempt at Saving data (Doesnt work yet) using persistant concepts
    public void saveSharedPref(ArrayList<String> workArray, ArrayList<String> courseArray){
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_FILE_NAME, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        for(int i = 0; i < workArray.size(); i++){
            editor.putString("workID" + i, workArray.get(i));
            editor.putString("courseID" + i, courseArray.get(i));
        }

        editor.commit();

        Toast.makeText(this,"done saving data", Toast.LENGTH_LONG).show();
    }

    //Listener to add work button
    private void handleAddWorkClick(){
        Intent intent = new Intent(UserAreaActivity.this, AddWorkActivity.class);
        UserAreaActivity.this.startActivity(intent);
    }
}


