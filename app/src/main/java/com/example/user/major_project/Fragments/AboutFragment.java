package com.example.user.major_project.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.major_project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created AboutFragment which extends Fragment


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Called to have the fragment instantiate its user interface view. This is optional, and non-graphical fragments can return null (which is the default implementation).
        // This will be called between onCreate(Bundle) and onActivityCreated(Bundle).
        // Inflate the layout for this fragment
        //View : Return the View for the fragment's UI, or null.
        return inflater.inflate(R.layout.fragment_about, container, false);
        //Inflater : The LayoutInflater object that can be used to inflate any views in the fragment.
        //returns the inflater and the considering the layout of particular fragment.
        //container : If non-null, this is the parent view that the fragment's UI should be attached to.
    }
}
