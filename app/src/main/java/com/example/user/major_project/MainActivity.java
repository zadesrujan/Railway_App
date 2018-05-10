package com.example.user.major_project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.user.major_project.Fragments.AboutFragment;
import com.example.user.major_project.Fragments.CodeToNameFragment;
import com.example.user.major_project.Fragments.LtsFragment;
import com.example.user.major_project.Fragments.NameToCodeFragment;
import com.example.user.major_project.Fragments.TrainFareFragment;
import com.example.user.major_project.Fragments.TrainNumberFragment;
import com.example.user.major_project.Pojo.Route;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,TrainFareFragment.OnFragmentInteractionListener,LtsFragment.OnFragmentInteractionListener{
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created MainActivity which extends AppCompatActivity that implents navigation and interaction listner.
    FrameLayout frameLayout;
    Route route;
    List<Route>routeList;
    //declaring the variables


    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //setting the layout

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //giving id to the tool bar


        FragmentManager fragmentManager = getSupportFragmentManager();
        //cretaed object and calling support manager.
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        //Start a series of edit operations on the Fragments associated with this FragmentManager.
        fragmentTransaction.add(R.id.frame, new TrainNumberFragment() );
        //adding frame to the transaction
        fragmentTransaction.commit();
        //commiting the transaction

        FrameLayout frameLayout = findViewById(R.id.frame);
        //giving id to to the new object

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //giving id to get items id and store in id

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //giving id to get items id and store in id

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (id == R.id.tarin_number) {
            fragmentTransaction.replace(R.id.frame,new TrainNumberFragment());
            fragmentTransaction.commit();
            // Handle the camera action
        } else if (id == R.id.train_status) {
            fragmentTransaction.replace(R.id.frame,new LtsFragment());
            fragmentTransaction.commit();

        }  else if (id == R.id.fare) {
            fragmentTransaction.replace(R.id.frame,new TrainFareFragment());
            fragmentTransaction.commit();

        } else if (id == R.id.name_code) {
            fragmentTransaction.replace(R.id.frame,new NameToCodeFragment());
            fragmentTransaction.commit();

        } else if (id == R.id.code_name) {
            fragmentTransaction.replace(R.id.frame,new CodeToNameFragment());
            fragmentTransaction.commit();

        } else if (id == R.id.about) {
            fragmentTransaction.replace(R.id.frame, new AboutFragment());
            fragmentTransaction.commit();
        }
        //we used on Navigation pressed method to slide the app and get the other informations about the app
        //using if and else condition.

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onFragmentInteraction(double uri,String fromstation, String tostation,String Trainnumber,String Trainname) {
        Intent intent = new Intent(this,Results_activity.class);
        intent.putExtra("key",uri);
        intent.putExtra("fs",fromstation);
        intent.putExtra("ts",tostation);
        intent.putExtra("tnumber",Trainnumber);
        intent.putExtra("tname",Trainname);
        startActivity(intent);
        //using fragmentinteraction we are communicationg the amin activity with fragment
        //and with intent we are moving the data from fragment to main activity.
    }


    @Override
    public void onFragmentInteraction(String trainnumbr, String trainname, String position, String source, String destination/*, List<Route> route*/) {
     // route = new ArrayList<Route>();
        Intent intent2 =new Intent(this,Ltsresult.class);
        intent2.putExtra("trnnum",trainnumbr);
        intent2.putExtra("trnnme",trainname);
        intent2.putExtra("postn",position);
        intent2.putExtra("src",source);
        intent2.putExtra("dest",destination);
        //   intent2.putExtra("routelist", (Parcelable) routeList);
        startActivity(intent2);
        //using fragmentinteraction we are communicationg the amin activity with fragment
        //and with intent we are moving the data from fragment to main activity.

    }
}
