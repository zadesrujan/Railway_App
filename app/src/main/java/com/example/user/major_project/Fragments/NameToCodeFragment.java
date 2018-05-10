package com.example.user.major_project.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.major_project.Pojo.Ltsmodel;
import com.example.user.major_project.Pojo.Name2code;
import com.example.user.major_project.Pojo.NameStation;
import com.example.user.major_project.R;
import com.example.user.major_project.Retrofit.ApiClient;
import com.example.user.major_project.Retrofit.ApiInterface;
import com.example.user.major_project.name2codeAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NameToCodeFragment extends Fragment {
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created NameToCodeFragment which extends Fragment
RecyclerView recyclerView;
EditText editText;
Button button;
name2codeAdapter adapter;
List<NameStation> nameStationList;
//declared the values

    public NameToCodeFragment() {
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
        return inflater.inflate(R.layout.fragment_name_to_code, container, false);
        //Inflater : The LayoutInflater object that can be used to inflate any views in the fragment.
        //returns the inflater and the considering the layout of particular fragment.
        //container : If non-null, this is the parent view that the fragment's UI should be attached to.
    }
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //OnViewCreated is called just after onCreateView and get has parameter the inflated view. Its return type is void
        editText=view.findViewById(R.id.stname);
        button=view.findViewById(R.id.submit);
        recyclerView=view.findViewById(R.id.n2c);
        //giving ids to the particular layouts.
        nameStationList=new ArrayList<>();
        //created new array list
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //setting the layoutmanager and created the new layoutmanagaer object and getting context and setting
        //orientation as vertical and reverse layout as false.
        adapter=new name2codeAdapter(nameStationList,getActivity());
        //created  new object
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //giving item decoration to the recycler view
        recyclerView.setAdapter(adapter);
        //setting recycler view to the adapter

        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //created new object and getting the info from api client and setting to the apiinterface class
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //created button set onclick listner so whenever we press the button some action to be done.
                if(!editText.getText().toString().isEmpty()) {
                    //using if condition so that showing to the user to fill the details
                    final retrofit2.Call<Name2code> name2codeCall = apiInterface.getstationame(editText.getText().toString(), getResources().getString(R.string.apikey));
                    //calling code 2 name from the retrofit and applying to the object while we get the station code parameters from the apiinterface.
                    name2codeCall.enqueue(new Callback<Name2code>() {
                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onResponse(Call<Name2code> call, Response<Name2code> response) {
                            //Invoked for a received HTTP response.
                            Name2code name2code = new Name2code();
                            name2code.setStations(response.body().getStations());
                            editText.setText(" ");
                            //created new objects and getting the details from stationclass which includes in POJO.

                            for (int i = 0; i < name2code.getStations().size(); i++) {
                                NameStation nameStation = new NameStation();
                                nameStation.setName(name2code.getStations().get(i).getName());
                                nameStation.setCode(name2code.getStations().get(i).getCode());
                                //using for loop we will get the size of the stations and the code of stations
                                //and adding these code to the list
                                nameStationList.add(nameStation);
                            }
                            adapter.notifyDataSetChanged();
                            //nametv.setText(name2code.getStations().get(0).getName());
                            //nametv.setText(response.body().getStations().get(0).getCode());
                        }

                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onFailure(Call<Name2code> call, Throwable t) {
                            //Invoked when a network exception occurred talking to the server or
                            // when an unexpected exception occurred creating the request or processing the response.
                        }
                    });

                }else{
                    editText.setError("Please fill the details");
                }
            }
        });
    }
}
