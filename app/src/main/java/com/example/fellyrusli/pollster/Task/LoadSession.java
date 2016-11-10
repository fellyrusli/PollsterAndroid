package com.example.fellyrusli.pollster.Task;

import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fellyrusli.pollster.Activity.ApplicationController;
import com.example.fellyrusli.pollster.R;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGetHC4;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

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
        RequestQueue queue = Volley.newRequestQueue(this.applicationController);
        String url = applicationController.getResources().getString(R.string.url) + applicationController.getResources().getString(R.string.getquestion) + "12345";
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                applicationController.getSessionFragment().setQuestion(response);
                Log.i("onResponse", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("onError", error.getMessage());
            }
        });
        queue.add(stringRequest);
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
