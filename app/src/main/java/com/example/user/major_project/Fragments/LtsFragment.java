package com.example.user.major_project.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.user.major_project.Pojo.LtsTrain;
import com.example.user.major_project.Pojo.Ltsmodel;
import com.example.user.major_project.Pojo.Route;
import com.example.user.major_project.Pojo.Station;
import com.example.user.major_project.R;
import com.example.user.major_project.Retrofit.ApiClient;
import com.example.user.major_project.Retrofit.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LtsFragment extends Fragment  {
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created LtsFragment which extends Fragment
    EditText editText;
    Button button;
    Date date;
    String fd;
    OnFragmentInteractionListener mListener;


    public LtsFragment() {
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        date = Calendar.getInstance().getTime();
        fd= formatter.format(date);
        return inflater.inflate(R.layout.fragment_lts, container, false);
        //Inflater : The LayoutInflater object that can be used to inflate any views in the fragment.
        //returns the inflater and the considering the layout of particular fragment.
        //container : If non-null, this is the parent view that the fragment's UI should be attached to.
    }
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //OnViewCreated is called just after onCreateView and get has parameter the inflated view. Its return type is void
        editText=view.findViewById(R.id.editText2);
        button=view.findViewById(R.id.Show);
        //giving ids to the layout
        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //created new object and getting the info from api client and setting to the apiinterface class.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //created button set onclick listner so whenever we press the button some action to be done.
                if(!editText.getText().toString().isEmpty()) {
                    //using if condition so that showing to the user to fill the details
                    retrofit2.Call<Ltsmodel> ltsmodelCall = apiInterface.getltsdetails(Integer.parseInt(editText.getText().toString()), fd,getResources().getString(R.string.apikey));
                    //calling code 2 name from the retrofit and applying to the object while we get the station code parameters from the apiinterface.
                    ltsmodelCall.enqueue(new Callback<Ltsmodel>() {
                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onResponse(retrofit2.Call<Ltsmodel> call, Response<Ltsmodel> response) {
                            //Invoked for a received HTTP response.
                            List<Route> routeList = new ArrayList<>();
                            //created the new arraylist
                            Ltsmodel ltsmodel = new Ltsmodel();
                            ltsmodel.setPosition(response.body().getPosition());
                            LtsTrain ltsTrain = new LtsTrain();
                            ltsTrain.setName(response.body().getTrain().getName());
                            ltsTrain.setNumber(response.body().getTrain().getNumber());
                            ltsmodel.setRoute(response.body().getRoute());
                            //creating the new objects and getting the position,getting train name,number from the class of pojo ltsmodel

                            for (int i = 0; i < response.body().getRoute().size(); i++) {
                                Route route = new Route();
                                Station station = new Station();
                                String stnName = ltsmodel.getRoute().get(i).getStation().getName();
                                String scarr = ltsmodel.getRoute().get(i).getScharr();
                                String scdep = ltsmodel.getRoute().get(i).getSchdep();
                                String actarr = ltsmodel.getRoute().get(i).getActarr();
                                String actdep = ltsmodel.getRoute().get(i).getActdep();
                                long lm = ltsmodel.getRoute().get(i).getLatemin();
                                long dist = ltsmodel.getRoute().get(i).getDistance();
                                station.setName(stnName);
                                route.setScharr(scarr);
                                route.setSchdep(scdep);
                                route.setActarr(actarr);
                                route.setActdep(actdep);
                                route.setLatemin(lm);
                                route.setDistance(dist);
                                route.setStation(station);
                                //using for loop we are getting the size of the model lts which includes name,departure,distance.
                                //and setting to the object.
                                routeList.add(route);
                                //adding the routelist to the route.
                            }
                            Log.d("List size", routeList.toString());
                            onButtonPressed(ltsTrain.getNumber(), ltsTrain.getName(), ltsmodel.getPosition(), ltsmodel.getRoute().get(0).getStation().getName(), ltsmodel.getRoute().get(ltsmodel.getRoute().size() - 1).getStation().getName());
                            //we get the details of train like position,name,route while pressed on button
                        }

                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onFailure(retrofit2.Call<Ltsmodel> call, Throwable t) {
                            //Invoked when a network exception occurred talking to the server or
                            // when an unexpected exception occurred creating the request or processing the response.
                        }
                    });

                }else {
                    editText.setError("Please fill the details");
                }
            }
        });}

    public void onButtonPressed(String trainnumbr,String trainname,String position,String source,String destination) {
        if (mListener != null) {
            mListener.onFragmentInteraction(trainnumbr,trainname,position,source,destination);
            //we use onButtonpresssed method for interaction between the fragment and the activity.
        }
    }
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LtsFragment.OnFragmentInteractionListener) {
            mListener = (LtsFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
            //we use onattach method whether we use to check that the fragment is connected to the activity or not
        }
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onDetach() {
        super.onDetach();
        mListener = null;
        //if not attached it will shows as null.
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        //it is used to communicate with the activity and the fragment.
        // TODO: Update argument type and name
       void onFragmentInteraction(String trainnumbr,String trainname,String position,String source,String destination);
        //void onFragmentInteraction(String trainnumbr,String trainname,String position,String source,String destination);
    }
}


