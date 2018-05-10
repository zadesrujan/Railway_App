package com.example.user.major_project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class Results_activity extends AppCompatActivity {
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created Results_activity which extends AppCompatActivity
TextView tv,fromstationtv,tostationtv,tnumbertv,tnametv;
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
        setContentView(R.layout.results_activity);
        //setting the layout

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv=findViewById(R.id.tv);
        fromstationtv=findViewById(R.id.fs);
        tostationtv=findViewById(R.id.ts);
        tnumbertv=findViewById(R.id.tnumber);
        tnametv=findViewById(R.id.tname);
        setSupportActionBar(toolbar);
        //giving ids to the layout

        double fare = getIntent().getExtras().getDouble("key");
        Log.d("fare",String.valueOf(fare));
        tv.setText("Fare: "+" \u20B9 "+String.valueOf(fare));
        //getting the intent values and setting to the text

        String fromstation =getIntent().getExtras().getString("fs");
        fromstationtv.setText("From Station: "+fromstation);
        //getting the intent values and setting to the text

        String tostation = getIntent().getExtras().getString("ts");
        tostationtv.setText("To Station: "+tostation);
        //getting the intent values and setting to the text

        String Trainnumber = getIntent().getExtras().getString("tnumber");
        tnumbertv.setText("Train Number: "+Trainnumber);
        //getting the intent values and setting to the text

        String Trainname = getIntent().getExtras().getString("tname");
        tnametv.setText(Trainname);
        //getting the intent values and setting to the text
    }
    }
