package com.example.user.major_project.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.major_project.Pojo.Code2name;
import com.example.user.major_project.Pojo.CodeStation;
import com.example.user.major_project.Pojo.NameStation;
import com.example.user.major_project.R;
import com.example.user.major_project.Retrofit.ApiClient;
import com.example.user.major_project.Retrofit.ApiInterface;
import com.example.user.major_project.code2nameAdapter;
import com.example.user.major_project.name2codeAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CodeToNameFragment extends Fragment {
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created CodeToNameFragment which extends Fragment
    EditText editText;
    RecyclerView recyclerView;
    Button button;
    List<CodeStation> codeStationList;
    code2nameAdapter codeAdapter;


    public CodeToNameFragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_code_to_name, container, false);
        //Inflater : The LayoutInflater object that can be used to inflate any views in the fragment.
        //returns the inflater and the considering the layout of particular fragment.
        //container : If non-null, this is the parent view that the fragment's UI should be attached to.
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //OnViewCreated is called just after onCreateView and get has parameter the inflated view. Its return type is void
        editText=view.findViewById(R.id.stcde);
        button=view.findViewById(R.id.submit);
        recyclerView=view.findViewById(R.id.c2n);
        //giving ids to the particular layouts.

        codeStationList = new ArrayList<>();
        //created new array list
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //setting the layoutmanager and created the new layoutmanagaer object and getting context and setting
        //orientation as vertical and reverse layout as false.
        codeAdapter=new code2nameAdapter(codeStationList,getActivity());
        //created  new object
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //giving item decoration to the recycler view
        recyclerView.setAdapter(codeAdapter);
        //setting recycler view to the adapter


        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //created new object and getting the info from api client and setting to the apiinterface class
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //created button set onclick listner so whenever we press the button some action to be done.
                if (!editText.getText().toString().isEmpty()) {
                    //using if condition so that showing to the user to fill the details
                    final retrofit2.Call<Code2name> code2nameCall = apiInterface.getstationcode(editText.getText().toString(), getResources().getString(R.string.apikey));
                    //calling code 2 name from the retrofit and applying to the object while we get the station code parameters from the apiinterface.
                    code2nameCall.enqueue(new Callback<Code2name>() {
                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onResponse(Call<Code2name> call, Response<Code2name> response) {
                            //Invoked for a received HTTP response.
                            Code2name code2name = new Code2name();
                            code2name.setStations(response.body().getStations());
                            editText.setText(" ");
                            for (int i = 0; i < code2name.getStations().size(); i++) {
                                CodeStation codeStation = new CodeStation();
                                codeStation.setCode(code2name.getStations().get(i).getCode());
                                codeStation.setName(code2name.getStations().get(i).getName());
                                codeStationList.add(codeStation);
                                //using for loop we will get the size of the stations and the code of stations
                                //and adding these code to the list
                            }
                            codeAdapter.notifyDataSetChanged();
                        }

                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onFailure(Call<Code2name> call, Throwable t) {
                            //Invoked when a network exception occurred talking to the server or
                            // when an unexpected exception occurred creating the request or processing the response.
                        }
                    });
                }
                else{
                    editText.setError("Please fill the Details");
                }
            }
        });
    }
}
