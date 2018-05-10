package com.example.user.major_project.Retrofit;

import com.example.user.major_project.Pojo.Code2name;
import com.example.user.major_project.Pojo.Ltsmodel;
import com.example.user.major_project.Pojo.Main;
import com.example.user.major_project.Pojo.Name2code;
import com.example.user.major_project.Pojo.NameORnumber;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by User on 22-03-2018.
 */

public interface ApiInterface {
    //created interface as ApiInterafce

    @GET("fare/train/{number}/source/{srcstn_code}/dest/{deststn_code}/age/{age}/pref/{class_code}/quota/{quota_code}/date/{date}/apikey/{apikey}")
    //we are getting the url of fair details as it includes train number,name src code,destination code,age,quota,date and the api key.
    Call<Main>getFairdetails(@Path("number") int trainNumber,@Path("srcstn_code") String srcStnCode,@Path("deststn_code") String destiStnCode,@Path("age") int age,@Path("class_code") String classCode,@Path("quota_code") String quotaCode,@Path("date") String date,@Path("apikey")String apikey);
    //we are calling the main class from POJO and declaring them as int,string.

    @GET("live/train/{number}/date/{date}/apikey/{apikey}")
    //we are getting the url of live train as it includes the train number,date and the apikey
    Call<Ltsmodel>getltsdetails(@Path("number")int trainNumber, @Path("date") String date, @Path("apikey")String apikey);
    //we are calling the Ltsmodel class from POJO and declaring them as int,string.

    @GET("name-to-code/station/{stnname}/apikey/{apikey}")
    //we are getting the url name to code as it includes station name and api key.
    Call<Name2code>getstationame(@Path("stnname")String stationame,@Path("apikey")String apikey);
    //we are calling the Name2Code class from POJO and declaring them as int,string.

    @GET("code-to-name/code/{stncode}/apikey/{apikey}")
        //we are getting the url name to code as it includes station name and api key.
    Call<Code2name>getstationcode(@Path("stncode")String stationcode,@Path("apikey")String apikey);
    //we are calling the Code2Name class from POJO and declaring them as int,string.

    @GET ("name-number/train/{nameornumber}/apikey/{apikey}")
    //we are getting the url name and number as it includes tarin name,number and api key.
    Call<NameORnumber>gettrainname(@Path("nameornumber")String trainnumber,@Path("apikey")String apikey);
    //we are calling the NameORnumber class from POJO and declaring them as int,string.
}
