package com.example.fellyrusli.pollster.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fellyrusli.pollster.Activity.ApplicationController;
import com.example.fellyrusli.pollster.R;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

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
        String url = getResources().getString(R.string.url) + getResources().getString(R.string.test);

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
        Intent intent = new Intent(this, ApplicationController.class);
        startActivity(intent);
    }

    public void setLoginPressed(boolean loginPressed) {
        this.loginPressed = loginPressed;
    }

}
