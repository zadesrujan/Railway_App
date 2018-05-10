package com.example.user.major_project.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.major_project.Pojo.ClassesR;
import com.example.user.major_project.Pojo.Day;
import com.example.user.major_project.Pojo.NameORnumber;
import com.example.user.major_project.Pojo.Trainname;
import com.example.user.major_project.R;
import com.example.user.major_project.Retrofit.ApiClient;
import com.example.user.major_project.Retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrainNumberFragment extends Fragment {
    //public is a method and fields can be accessed by the members of any class.
//class is a collections of objects.
//created TrainNumberFragment which extends Fragment
    EditText editText;
    Button button;
    List<Day> dayList;
    Trainname trainname;
    List<ClassesR> classesRList;
    TextView tname,tnumber,twoa,fc,onea,be,twos,sl,cc,threea,mo,tu,we,th,fr,sa,su,clscode,clscode1,clscode2,clscode3,clscode4,clscode5,clscode6,clscode7;
    ImageView im,im1,im2,im3,im4,im5,im6,im7;
    //declaring the values
    public TrainNumberFragment() {
        // Required empty public constructor
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Called to have the fragment instantiate its user interface view. This is optional, and non-graphical fragments can return null (which is the default implementation).
        // This will be called between onCreate(Bundle) and onActivityCreated(Bundle).
        //View : Return the View for the fragment's UI, or null.
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_train_number, null, false);
        //Inflater : The LayoutInflater object that can be used to inflate any views in the fragment.
        //returns the inflater and the considering the layout of particular fragment.
        //container : If non-null, this is the parent view that the fragment's UI should be attached to.
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText=view.findViewById(R.id.editText13);
        button=view.findViewById(R.id.button8);
        tname=view.findViewById(R.id.trainname);
        tnumber=view.findViewById(R.id.trainnumber);
        clscode=view.findViewById(R.id.classcode);
        clscode1=view.findViewById(R.id.classcode1);
        clscode2=view.findViewById(R.id.classcode2);
        clscode3=view.findViewById(R.id.classcode3);
        clscode4=view.findViewById(R.id.classcode4);
        clscode5=view.findViewById(R.id.classcode5);
        clscode6=view.findViewById(R.id.classcode6);
        clscode7=view.findViewById(R.id.classcode7);
        twoa=view.findViewById(R.id.twoA);
        fc=view.findViewById(R.id.Fc);
        onea=view.findViewById(R.id.oneA);
        be=view.findViewById(R.id.Be);
        twos=view.findViewById(R.id.twoS);
        sl=view.findViewById(R.id.SL);
        cc=view.findViewById(R.id.CC);
        threea=view.findViewById(R.id.threeA);
        mo=view.findViewById(R.id.mon);
        tu=view.findViewById(R.id.tue);
        we=view.findViewById(R.id.wed);
        th=view.findViewById(R.id.thur);
        fr=view.findViewById(R.id.fri);
        sa=view.findViewById(R.id.sat);
        su=view.findViewById(R.id.sun);
        im=view.findViewById(R.id.imageView);
        im1=view.findViewById(R.id.imageView1);
        im2=view.findViewById(R.id.imageView2);
        im3=view.findViewById(R.id.imageView3);
        im4=view.findViewById(R.id.imageView4);
        im5=view.findViewById(R.id.imageView5);
        im6=view.findViewById(R.id.imageView6);
        im7=view.findViewById(R.id.imageView7);
        //giving ids to the prefered layouts

        dayList=new ArrayList<>();
        classesRList=new ArrayList<>();
        //cretaed new arraylist

        final ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        //created new object and getting the info from api client and setting to the apiinterface class.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //created button set onclick listner so whenever we press the button some action to be done.
                if(!editText.getText().toString().isEmpty()) {
                    //using if condition so that showing to the user to fill the details
                    final retrofit2.Call<NameORnumber> nameORnumberCall = apiInterface.gettrainname(editText.getText().toString(), getResources().getString(R.string.apikey));
                    //calling code 2 name from the retrofit and applying to the object while we get the station code parameters from the apiinterface.
                    nameORnumberCall.enqueue(new Callback<NameORnumber>() {
                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onResponse(Call<NameORnumber> call, Response<NameORnumber> response) {
                            //Invoked for a received HTTP response.
                            trainname = new Trainname();
                            trainname.setClasses(response.body().getTrain().getClasses());
                            trainname.setDays(response.body().getTrain().getDays());
                            classesRList = response.body().getTrain().getClasses();
                            dayList = response.body().getTrain().getDays();
                            //created new objects and getting the details from stationclass which includes in POJO.
                            tname.setText(response.body().getTrain().getName());
                            tnumber.setText(response.body().getTrain().getNumber());
                            //getting objects and setting to the text of train name and number.
                            for (int i = 0; i < trainname.getClasses().size(); i++) {

                                switch (i) {
                                    case 0:
                                        if (classesRList.get(i).getAvailable().equals("Y")) {
                                            im.setImageResource(R.drawable.green);
                                            clscode.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        } else if (classesRList.get(i).getAvailable().equals("N")) {
                                            im.setImageResource(R.drawable.red);
                                            clscode.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        }
                                        break;

                                    case 1:
                                        if (classesRList.get(i).getAvailable().equals("Y")) {
                                            im1.setImageResource(R.drawable.green);
                                            clscode1.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        } else if (classesRList.get(i).getAvailable().equals("N")) {
                                            im1.setImageResource(R.drawable.red);
                                            clscode1.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        }
                                        break;

                                    case 2:
                                        if (classesRList.get(i).getAvailable().equals("Y")) {
                                            im2.setImageResource(R.drawable.green);
                                            clscode2.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        } else if (classesRList.get(i).getAvailable().equals("N")) {
                                            im2.setImageResource(R.drawable.red);
                                            clscode2.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        }
                                        break;
                                    case 3:
                                        if (classesRList.get(i).getAvailable().equals("Y")) {
                                            im3.setImageResource(R.drawable.green);
                                            clscode3.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        } else if (classesRList.get(i).getAvailable().equals("N")) {
                                            im3.setImageResource(R.drawable.red);
                                            clscode3.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        }
                                        break;

                                    case 4:
                                        if (classesRList.get(i).getAvailable().equals("Y")) {
                                            im4.setImageResource(R.drawable.green);
                                            clscode4.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        } else if (classesRList.get(i).getAvailable().equals("N")) {
                                            im4.setImageResource(R.drawable.red);
                                            clscode4.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        }
                                        break;
                                    case 5:
                                        if (classesRList.get(i).getAvailable().equals("Y")) {
                                            im5.setImageResource(R.drawable.green);
                                            clscode5.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        } else if (classesRList.get(i).getAvailable().equals("N")) {
                                            im5.setImageResource(R.drawable.red);
                                            clscode5.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        }
                                        break;
                                    case 6:
                                        if (classesRList.get(i).getAvailable().equals("Y")) {
                                            im6.setImageResource(R.drawable.green);
                                            clscode6.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        } else if (classesRList.get(i).getAvailable().equals("N")) {
                                            im6.setImageResource(R.drawable.red);
                                            clscode6.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        }
                                        break;

                                    case 7:
                                        if (classesRList.get(i).getAvailable().equals("Y")) {
                                            im7.setImageResource(R.drawable.green);
                                            clscode7.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        } else if (classesRList.get(i).getAvailable().equals("N")) {
                                            im7.setImageResource(R.drawable.red);
                                            clscode7.setText(response.body().getTrain().getClasses().get(i).getCode());
                                        }
                                        break;
                                }
                                //using for loop and switch cases we are declaring that if the response is available as Y it must be green
                                //if respose is available as N it must show as red

                            }
                            for (int i = 0; i < trainname.getDays().size(); i++) {
                                switch (i) {
                                    case 0:
                                        if (dayList.get(i).getRuns().equals("Y")) {
                                            mo.setText(dayList.get(i).getCode());
                                            mo.setTextColor(getResources().getColor(R.color.av));
                                        } else if (dayList.get(i).getRuns().equals("N")) {
                                            mo.setText(dayList.get(i).getCode());
                                            mo.setTextColor(getResources().getColor(R.color.na));
                                        }
                                        break;
                                    case 1:
                                        if (dayList.get(i).getRuns().equals("Y")) {
                                            tu.setText(dayList.get(i).getCode());
                                            tu.setTextColor(getResources().getColor(R.color.av));
                                        } else if (dayList.get(i).getRuns().equals("N")) {
                                            tu.setText(dayList.get(i).getCode());
                                            tu.setTextColor(getResources().getColor(R.color.na));
                                        }
                                        break;
                                    case 2:
                                        if (dayList.get(i).getRuns().equals("Y")) {
                                            we.setText(dayList.get(i).getCode());
                                            we.setTextColor(getResources().getColor(R.color.av));
                                        } else if (dayList.get(i).getRuns().equals("N")) {
                                            we.setText(dayList.get(i).getCode());
                                            we.setTextColor(getResources().getColor(R.color.na));
                                        }
                                        break;
                                    case 3:
                                        if (dayList.get(i).getRuns().equals("Y")) {
                                            th.setText(dayList.get(i).getCode());
                                            th.setTextColor(getResources().getColor(R.color.av));
                                        } else if (dayList.get(i).getRuns().equals("N")) {
                                            th.setText(dayList.get(i).getCode());
                                            th.setTextColor(getResources().getColor(R.color.na));
                                        }
                                        break;
                                    case 4:
                                        if (dayList.get(i).getRuns().equals("Y")) {
                                            fr.setText(dayList.get(i).getCode());
                                            fr.setTextColor(getResources().getColor(R.color.av));
                                        } else if (dayList.get(i).getRuns().equals("N")) {
                                            fr.setText(dayList.get(i).getCode());
                                            fr.setTextColor(getResources().getColor(R.color.na));
                                        }
                                        break;
                                    case 5:
                                        if (dayList.get(i).getRuns().equals("Y")) {
                                            sa.setText(dayList.get(i).getCode());
                                            sa.setTextColor(getResources().getColor(R.color.av));
                                        } else if (dayList.get(i).getRuns().equals("N")) {
                                            sa.setText(dayList.get(i).getCode());
                                            sa.setTextColor(getResources().getColor(R.color.na));
                                        }
                                        break;
                                    case 6:
                                        if (dayList.get(i).getRuns().equals("Y")) {
                                            su.setText(dayList.get(i).getCode());
                                            su.setTextColor(getResources().getColor(R.color.av));
                                        } else if (dayList.get(i).getRuns().equals("N")) {
                                            su.setText(dayList.get(i).getCode());
                                            su.setTextColor(getResources().getColor(R.color.na));
                                        }
                                        break;
                                    //using for loop and switch cases we are declaring that if the response is available as Y it must be green
                                    //if respose is available as N it must show as red
                                }
                            }
                        }

                        @Override
                        //we use override to tells the compiler that the following method overrides a method of its superclass.
                        public void onFailure(Call<NameORnumber> call, Throwable t) {
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
