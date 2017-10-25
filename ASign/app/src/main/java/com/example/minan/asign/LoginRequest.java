package com.example.minan.asign;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mina N on 10/25/2017.
 * Used to Login into a registered account
 */

public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL ="https://mmnashed.000webhostapp.com/ASign/Login.php";

    private Map<String,String> params;

    public LoginRequest(String uname, String password, Response.Listener<String> listener){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null); //Null is for and error listener
        params = new HashMap<>();

        params.put("uname", uname);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
