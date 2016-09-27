package com.example.fellyrusli.pollster;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

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
        if (loginPressed) {
            loginPressed = true;
        }
    }

}
