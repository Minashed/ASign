package com.example.minan.asign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Mina N on 12/14/2017.
 */

public class WorkListAdaptor extends BaseAdapter {
    //Instance varibales to store data
    ArrayList<String>  workName;
    ArrayList<String>  course;
    Context context;

    public WorkListAdaptor(UserAreaActivity con, ArrayList<String> wName, ArrayList<String> c){
        context = con;
        workName = wName;
        course = c;
    }

    @Override
    public int getCount() {
        return workName.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //Reference to the current row being rendered
        View row = null;

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Use the layout inflator instace to instatiate the new view of the "correct type"
        row = layoutInflater.inflate(R.layout.custom_work_list, null);

        //We need to set up the views that will go into the custom list
        TextView work = (TextView) row.findViewById(R.id.tvWork);
        work.setText(workName.get(position));

        TextView dueDate = (TextView) row.findViewById(R.id.tvDDate);
        dueDate.setText(course.get(position ));

        return row;
    }
}
