package com.example.user.major_project.Retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 22-03-2018.
 */

public class ApiClient {
    //created class as API client
    public static final String Base_URL = "https://api.railwayapi.com/v2/";
    //using the url of railway api
    private static Retrofit retrofit = null;
    //intial decleartion retrofit as null

    public static Retrofit getClient(){
        //created a method
        if (retrofit==null) {
            //if retrofit is null it will do such following thing.
            retrofit = new Retrofit.Builder().baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.create()).build();
        //building new retrofit with the url and for finding the variables which are in annoitations we use Gson converter factory
            //and saying to create
        }
        return retrofit;
        //returning to retrofit.
    }
}
