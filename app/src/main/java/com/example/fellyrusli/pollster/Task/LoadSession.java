package com.example.fellyrusli.pollster.Task;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;

import com.example.fellyrusli.pollster.Activity.ApplicationController;
import com.example.fellyrusli.pollster.R;

/**
 * Created by fellyrusli on 10/14/2016.
 */
public class LoadSession extends AsyncTask<Void, Void, Void> {

    ApplicationController applicationController;
    ProgressDialog loadingScreen;

    public LoadSession (ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    @Override
    protected void onPreExecute() {
        while (true) {
            try{
                loadingScreen = new ProgressDialog(applicationController);
                loadingScreen.setTitle("Loading");
                loadingScreen.setCanceledOnTouchOutside(false);
                loadingScreen.show();
                break;
            } catch (RuntimeException e) {
                SystemClock.sleep(100);
            }
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Void ignore) {
        if (loadingScreen.isShowing()) {
            loadingScreen.dismiss();
        }

        FragmentTransaction fragmentTransaction = applicationController.getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.visible_view, applicationController.getSessionFragment());
        fragmentTransaction.show(applicationController.getSessionFragment())
                .hide(applicationController.getHomeFragment())
                .addToBackStack(null).commit();

        applicationController.getFragmentManager().executePendingTransactions();

    }
}
