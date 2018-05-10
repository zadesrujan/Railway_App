package com.example.user.major_project;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by User on 11-04-2018.
 */

public class Datepicker extends android.support.v4.app.DialogFragment implements DatePickerDialog.OnDateSetListener{
    //created the class of datepicker which extends the dilog format

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //created class as dialog which includes for creation of dialog box
        final Calendar c = Calendar.getInstance();
        //we are getting insatnce from calendar
        int year = c.get(Calendar.YEAR);
        //getting year from calendar
        int month = c.get(Calendar.MONTH);
        //getting month from calendar
        int day = c.get(Calendar.DAY_OF_MONTH);
        //getting day from calendar
        return new DatePickerDialog(getActivity(),this,year,month,day);
        //returning to date picker dialog box
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        //created a constructor which includes the date picker,year,month and day
        ((EditText) getActivity().findViewById(R.id.Date)).setText(dayOfMonth+"-"+month+"-"+year);
        //setting to the edit text.
    }
}
