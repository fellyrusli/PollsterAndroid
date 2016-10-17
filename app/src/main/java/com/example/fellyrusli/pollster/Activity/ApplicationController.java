package com.example.fellyrusli.pollster.Activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fellyrusli.pollster.Fragment.HomeFragment;
import com.example.fellyrusli.pollster.Fragment.QuestionFragment;
import com.example.fellyrusli.pollster.Fragment.SessionFragment;
import com.example.fellyrusli.pollster.Object.NavDrawerItem;
import com.example.fellyrusli.pollster.R;
import com.example.fellyrusli.pollster.Task.LoadHome;
import com.example.fellyrusli.pollster.Task.LoadQuestion;
import com.example.fellyrusli.pollster.Task.LoadSession;

import java.util.ArrayList;

/**
 * Created by fellyrusli on 9/27/2016.
 */
public class ApplicationController extends AppCompatActivity {
    private AsyncTask<Void, Void, Void> currentBackgroundTask;
    private static ApplicationController sharedActivity;

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView navList;
    private String[] navMenuTitles;

    public enum Panel {
        Home, Session, Question, Setting;
    }
    protected  Panel currentPanel = Panel.Home;

    protected HomeFragment homeFragment;
    protected SessionFragment sessionFragment;
    protected QuestionFragment questionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedActivity = this;

        setContentView(R.layout.application_controller_layout);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        final ArrayList < NavDrawerItem > navDrawerItems = new ArrayList<>();
        for (int i = 0; i < navMenuTitles.length; i++) {
            navDrawerItems.add(new NavDrawerItem(navMenuTitles[i]));
        }

        navList = (ListView) findViewById(R.id.list_slidermenu);
        navList.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return navDrawerItems.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.drawer_list_item, null);
                }

                TextView textView = (TextView) convertView.findViewById(R.id.title);
                textView.setText(navDrawerItems.get(position).getTitle());

                return convertView;
            }
        });
        navList.setOnItemClickListener(new navDrawerItemClickListener());

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Pollster");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle("Pollster");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        homeFragment = new HomeFragment();
        sessionFragment = new SessionFragment();
        questionFragment = new QuestionFragment();

        actionBarDrawerToggle.syncState();
        currentBackgroundTask = new LoadHome(this).execute();
        //setContentView();

    }

    private class navDrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                new LoadHome(getActivity()).execute();
            } else if (position == 1) {
                new LoadSession(getActivity()).execute();
            } else if (position == 2) {
                new LoadQuestion(getActivity()).execute();
            }
            drawerLayout.closeDrawers();
            invalidateOptionsMenu();
        }
    }

    @Override
    protected  void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.syncState();
    }

    public static ApplicationController getActivity() { return sharedActivity; }

    public AsyncTask<Void, Void, Void> getCurrentBackgroundTask() { return currentBackgroundTask; }
    public void setCurrentBackgroundTask (AsyncTask<Void, Void, Void> currentBackgroundTask) { this.currentBackgroundTask = currentBackgroundTask; }

    public HomeFragment getHomeFragment() { return homeFragment; }
    public void setHomeFragment(HomeFragment homeFragment) { this.homeFragment = homeFragment; }

    public SessionFragment getSessionFragment() { return sessionFragment; }
    public void setSessionFagment(SessionFragment sessionFragment) { this.sessionFragment = sessionFragment; }

    public QuestionFragment getQuestionFragment() { return questionFragment; }
    public void setQuestionFragment(QuestionFragment questionFragment) { this.questionFragment = questionFragment; }
}