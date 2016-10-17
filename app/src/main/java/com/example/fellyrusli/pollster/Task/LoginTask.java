package com.example.fellyrusli.pollster.Task;

import android.os.AsyncTask;

import com.example.fellyrusli.pollster.Activity.Login;

/**
 * Created by fellyrusli on 9/27/2016.
 */
public class LoginTask extends AsyncTask<Void, Void, Boolean> {
    Login context;

    public LoginTask(Login context) { this.context = context; }

    @Override
    protected  void onPreExecute() {
    }
    @Override
    protected Boolean doInBackground(Void... params) {
        return true;
    }

    @Override
    protected void onPostExecute(Boolean verified) {
        context.setLoginPressed(false);
    }
}
