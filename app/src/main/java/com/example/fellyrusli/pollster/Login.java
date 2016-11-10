package com.example.fellyrusli.pollster;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by fellyrusli on 9/8/2016.
 */
public class Login extends Activity {
    private boolean loginPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
    }

    /*
     *  Runs the Log
     */
    public void onLogin(View view) {
        //if (!loginPressed) {
            //loginPressed = true;

            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "http://guarded-oasis-14876.herokuapp.com/test";

            final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
            queue.add(stringRequest);
        //}
    }

    public void setLoginPressed(boolean loginPressed) {
        this.loginPressed = loginPressed;
    }

}
