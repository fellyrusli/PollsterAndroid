package com.example.fellyrusli.pollster.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fellyrusli.pollster.Activity.ApplicationController;
import com.example.fellyrusli.pollster.R;
import com.example.fellyrusli.pollster.Task.LoadSession;

/**
 * Created by fellyrusli on 9/27/2016.
 */
public class HomeFragment extends Fragment {
    TextView user;
    Button joinSession;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        if (savedInstanceState == null) {
            user = (TextView)view.findViewById(R.id.user);
            user.setText("George Burdell");
            joinSession = (Button)view.findViewById(R.id.join_session);
            String session = joinSession.getText().toString();
            joinSession.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new LoadSession(ApplicationController.getActivity()).execute();
                }
            });
        }
        return view;
    }

}
