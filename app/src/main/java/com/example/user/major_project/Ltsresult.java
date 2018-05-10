package com.example.user.major_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.major_project.Fragments.LtsFragment;
import com.example.user.major_project.Pojo.LtsTrain;
import com.example.user.major_project.Pojo.Ltsmodel;
import com.example.user.major_project.Pojo.Route;
import com.example.user.major_project.Pojo.Station;
import com.example.user.major_project.Retrofit.ApiClient;
import com.example.user.major_project.Retrofit.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class Ltsresult extends AppCompatActivity  {
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created Ltsresult which extends AppCompatActivity
    TextView textView,trnnumber,trnname,sr,ds;
    RecyclerView recyclerView;
    List<Route> routes;
    //declaring the variables.


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
        setContentView(R.layout.activity_ltsresult);
        //setting the layout

        trnnumber=findViewById(R.id.tnu);
        routes = new ArrayList<>();
        String ltstrainum = getIntent().getExtras().getString("trnnum");
        trnnumber.setText("Train Number: "+ltstrainum);

  /*      myAdapter =new MyAdapter(routes,Ltsresult.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(myAdapter);

  */      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView=findViewById(R.id.position);

        sr=findViewById(R.id.src);
        ds=findViewById(R.id.des);
        trnname=findViewById(R.id.tna);

        //giving ids to the layouts.

      /*  Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("bundle");
        ArrayList<Route> object = (ArrayList<Route>) args.getSerializable("Routelist");
        Log.d("Routelist",object.toString());
*/
        //getting the intent values and setting to the text

        String ltstrname = getIntent().getExtras().getString("trnnme");
        trnname.setText("Train Name: "+ltstrname);
        //getting the intent values and setting to the text

        String pos = getIntent().getExtras().getString("postn");
        textView.setText(pos);
        //getting the intent values and setting to the text

        String ltssrc = getIntent().getExtras().getString("src");
        sr.setText("From: "+ltssrc);
        //getting the intent values and setting to the text

        String ltsdes =getIntent().getExtras().getString("dest");
        ds.setText("To: "+ltsdes);
        //getting the intent values and setting to the text

    }

}
