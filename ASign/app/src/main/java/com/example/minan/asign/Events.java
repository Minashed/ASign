package com.example.minan.asign;

/**
 * Created by Mina N on 12/15/2017.
 */

public class Events {
    private int _id;
    private String _workname;
    private String _course;

    public Events(){

    }

    public Events(String workname, String course){
        this._workname = workname;
        this._course = course;
    }

    //Setters
    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_workname(String _workname) {
        this._workname = _workname;
    }

    public void set_course(String _course) {
        this._course = _course;
    }

    //Getters
    public int get_id() {
        return _id;
    }

    public String get_workname() {
        return _workname;
    }

    public String get_course() {
        return _course;
    }
}
