package com.example.minan.asign;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Mina N on 10/23/2017.
 * Used to Register an account
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL ="https://mmnashed.000webhostapp.com/ASign/Register.php";

    private Map<String,String> params;

    public RegisterRequest(String fname, String lname, String uname, String password, String email, String pnumber, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null); //Null is for and error listener
        params = new HashMap<>();
        params.put("fname", fname);
        params.put("lname", lname);

        params.put("uname", uname);
        params.put("password", password);

        params.put("email", email);
        params.put("pnumber", pnumber);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
