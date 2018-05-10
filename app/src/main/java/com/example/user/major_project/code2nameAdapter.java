package com.example.user.major_project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.major_project.Pojo.CodeStation;
import com.example.user.major_project.Pojo.NameStation;

import java.util.List;

public class code2nameAdapter extends RecyclerView.Adapter<code2nameAdapter.MyviewHolder> {
    //created class as code2name adapter
    List<CodeStation> codeStations;
    Context context;
    CodeStation codeStation;
    //declaring the variables.

    public code2nameAdapter(List<CodeStation> CodeStations, Context context) {
        //created the parametic constructor which includes the variables
        this.codeStations = CodeStations;
        this.context=context;
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //onCreateViewHolder only creates a new view holder when there are no existing view holders which the RecyclerView can reuse.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.name2code,parent,false);
        //created new object which includes inflater and get context from parent which includes the layout.
        return new MyviewHolder(view);
        //returing to MyviewHolder which includes view.

    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onBindViewHolder(MyviewHolder holder, int position) {
        //This method internally calls onBindViewHolder(ViewHolder, int) to update the RecyclerView.
        // ViewHolder contents with the item at the given position and also sets up some private fields to be used by RecyclerView.
        codeStation = codeStations.get(position);
        //getting the position.
        holder.textView.setText("Station Name : "+codeStation.getName());
        //for binding the data we use bind view holder and we are setting the text to get name.
        holder.textView1.setText("Station Code : "+codeStation.getCode());
        //for binding the data we use bind view holder and we are setting the text to get number.
    }
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public int getItemCount() {
        return codeStations.size();
        //Returns the total number of items in the data set held by the adapter.
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView1;
        public MyviewHolder(View itemView) {
            super(itemView);
            //ViewHolder design pattern is used to speed up rendering of your ListView,actually to make it work smoothly
            textView=itemView.findViewById(R.id.stationame);
            textView1=itemView.findViewById(R.id.stncode);
            //giving ids to the custom layouts
        }
    }
}
