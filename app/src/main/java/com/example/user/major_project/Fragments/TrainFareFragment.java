package com.example.user.major_project.Fragments;
//Package objects contain version information about the implementation and specification of a Java package.

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.user.major_project.Datepicker;
import com.example.user.major_project.Pojo.FromStation;
import com.example.user.major_project.Pojo.Main;
import com.example.user.major_project.Pojo.ToStation;
import com.example.user.major_project.Pojo.Train;
import com.example.user.major_project.R;
import com.example.user.major_project.Retrofit.ApiClient;
import com.example.user.major_project.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrainFareFragment extends Fragment {
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created TrainFareFragment which extends Fragment
EditText trainNumber,Source,Destination,Age,Date;
Spinner Quota,Class;
Button GetFare;
double fare;
String quotaselected,classselected;
String[] Quotaoptions= {"GN","TQ","PT","SS","LD","HP","DP","DF"};
String[] Classoptions= {"Sl","3A","2A","1A","CC","EC","2S","3E","FC"};
ArrayAdapter<String>QuotaAdapter,ClassAdapter;
OnFragmentInteractionListener mListener;
ImageButton imageButton;
//declaring the values

    public TrainFareFragment() {
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
        return inflater.inflate(R.layout.fragment_train_fare, container, false);
        //Inflater : The LayoutInflater object that can be used to inflate any views in the fragment.
        //returns the inflater and the considering the layout of particular fragment.
        //container : If non-null, this is the parent view that the fragment's UI should be attached to.
    }
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    //OnViewCreated is called just after onCreateView and get has parameter the inflated view. Its return type is void
        trainNumber = view.findViewById(R.id.train_number);
        Source = view.findViewById(R.id.Source);
        Destination = view.findViewById(R.id.Destination);
        Age = view.findViewById(R.id.Age);
        Date = view.findViewById(R.id.Date);
        Quota = view.findViewById(R.id.Quota);
        Class = view.findViewById(R.id.Class);
        GetFare = view.findViewById(R.id.fare);
        imageButton= view.findViewById(R.id.image);
        //giving the ids to the layouts
imageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //created button set onclick listner so whenever we press the button some action to be done.
        DialogFragment dialogFragment = new Datepicker();
        dialogFragment.show(getFragmentManager(),"Datepicker");
        //created new object and for showing the date picker dialog box we use datepicker dialog box.
    }
});
        QuotaAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, Quotaoptions);
        ClassAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, Classoptions);
        //creating new arrayadapter and selecting the simple dropdown items and which gives option which are already declared at first.
        Quota.setAdapter(QuotaAdapter);
        Class.setAdapter(ClassAdapter);
        //setting these to the adapters
        Quota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //for selection purpose we use these method
            @Override
            //we use override to tells the compiler that the following method overrides a method of its superclass.
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                quotaselected = (String) parent.getItemAtPosition(position);
                //whatever the item is selected it will get the position id from the parent.
            }
            @Override
            //we use override to tells the compiler that the following method overrides a method of its superclass.
            public void onNothingSelected(AdapterView<?> parent) {
                //if nothing is selected we use this method.
            }
        });
        Class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //for selection purpose we use these method
            @Override
            //we use override to tells the compiler that the following method overrides a method of its superclass.
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                classselected = (String) parent.getItemAtPosition(position);
                //whatever the item is selected it will get the position id from the parent.
            }
            @Override
            //we use override to tells the compiler that the following method overrides a method of its superclass.
            public void onNothingSelected(AdapterView<?> parent) {
                //if nothing is selected we use this method.
            }
        });

        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //created new object and getting the info from api client and setting to the apiinterface class
        GetFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //created button set onclick listner so whenever we press the button some action to be done.
                if(!trainNumber.getText().toString().isEmpty()) {
                    //using if condition so that showing to the user to fill the details
                    Call<Main> getfareenquirycall = apiInterface.getFairdetails(Integer.parseInt(trainNumber.getText().toString()), Source.getText().toString(), Destination.getText().toString(), Integer.parseInt(Age.getText().toString()), classselected, quotaselected, Date.getText().toString(), getResources().getString(R.string.apikey));
                    //calling code 2 name from the retrofit and applying to the object while we get the station code parameters from the apiinterface.
                    getfareenquirycall.enqueue(new Callback<Main>() {
                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onResponse(Call<Main> call, Response<Main> response) {
                            //Invoked for a received HTTP response.
                            Log.d("Fareurl", response.toString());
                            Main main = new Main();
                            fare = response.body().getFare();
                            main.setFare(response.body().getFare());
                            Log.d("Set Fare", String.valueOf(main.getFare()));
                            //creating new object and getting the fare from the fare class which is in POJO.

                            FromStation fromStation = new FromStation();
                            fromStation.setName(response.body().getFromStation().getName());
                            //creating new object and getting the name from the fromstation class which is in POJO.

                            ToStation toStation = new ToStation();
                            toStation.setName(response.body().getToStation().getName());
                            //creating new object and getting the name from the Tostation class which is in POJO.

                            Train trainobj = new Train();
                            trainobj.setNumber(response.body().getTrain().getNumber());
                            trainobj.setName(response.body().getTrain().getName());
                            //creating new object and getting the train name and number from the train class which is in POJO.

                            onButtonPressed(main.getFare(), fromStation.getName(), toStation.getName(), trainobj.getNumber(), trainobj.getName());
                            //we get the details of train like position,name,route while pressed on button
                        }

                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onFailure(Call<Main> call, Throwable t) {
                            //Invoked when a network exception occurred talking to the server or
                            // when an unexpected exception occurred creating the request or processing the response.
                        }
                    });

                }else
                    {trainNumber.setError("Please fill the details");
                }
            }
        });
    }
    public void onButtonPressed(double uri,String fromstation,String tostation,String Trainnumber,String Trainname) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri,fromstation,tostation,Trainnumber,Trainname);
            //we use onButtonpresssed method for interaction between the fragment and the activity.
        }
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TrainFareFragment.OnFragmentInteractionListener) {
            mListener = (TrainFareFragment.OnFragmentInteractionListener) context;
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
        void onFragmentInteraction(double uri,String fromstation,String tostation,String Trainnumber,String Trainname);
    }
    }

