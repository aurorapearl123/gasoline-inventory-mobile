package com.example.ian.kitrol;

import android.support.annotation.NonNull;


import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Make Drawer layout
    private DrawerLayout drawerLayout;
    //bar graph
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set up drawer
        drawerLayout = this.findViewById(R.id.drawable_layout);

        //get the navigation click listener
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //menu button top left of the activity
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //initialize barchart
        barChart = (BarChart) findViewById(R.id.bargraph);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(44f,0));
        barEntries.add(new BarEntry(88f,1));
        barEntries.add(new BarEntry(66f,2));
        barEntries.add(new BarEntry(12f,3));
        barEntries.add(new BarEntry(19f,4));
        barEntries.add(new BarEntry(91f,5));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");

        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("April");
        theDates.add("May");
        theDates.add("Jun");
        theDates.add("July");
        theDates.add("August");
        theDates.add("September");
//        theDates.add("April");
//        theDates.add("April");
//        theDates.add("April");
//        theDates.add("April");
//        theDates.add("April");
//        theDates.add("April");


        BarData theData = new BarData(theDates, barDataSet);
        barChart.setData(theData);
        barChart.setEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);




    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_dashboard:
                Toast.makeText(getApplicationContext(), "DASHBOARD", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_deposit:
                Toast.makeText(getApplicationContext(), "DEPOSIT", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_sales:
                Toast.makeText(getApplicationContext(), "SALES", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_inventory:
                Toast.makeText(getApplicationContext(), "INVENTORY", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_profile:
                Toast.makeText(getApplicationContext(), "PROFILE", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_logout:
                Toast.makeText(getApplicationContext(), "LOGOUT", Toast.LENGTH_LONG).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //notes check if the api is 19 or lower add style for version 21

}
