
package com.example.user.major_project.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ltsmodel {

    @SerializedName("debit")
    @Expose
    private long debit;
    @SerializedName("response_code")
    @Expose
    private long responseCode;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("train")
    @Expose
    private LtsTrain train;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("route")
    @Expose
    private List<Route> route = null;
    @SerializedName("current_station")
    @Expose
    private CurrentStation currentStation;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ltsmodel() {
    }

    /**
     * 
     * @param currentStation
     * @param position
     * @param startDate
     * @param responseCode
     * @param route
     * @param train
     * @param debit
     */
    public Ltsmodel(long debit, long responseCode, String position, LtsTrain train, String startDate, List<Route> route, CurrentStation currentStation) {
        super();
        this.debit = debit;
        this.responseCode = responseCode;
        this.position = position;
        this.train = train;
        this.startDate = startDate;
        this.route = route;
        this.currentStation = currentStation;
    }

    public long getDebit() {
        return debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(long responseCode) {
        this.responseCode = responseCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LtsTrain getTrain() {
        return train;
    }

    public void setTrain(LtsTrain train) {
        this.train = train;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    public CurrentStation getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(CurrentStation currentStation) {
        this.currentStation = currentStation;
    }


}
//used getters and setters for debit,response code,position,train,start date,list of routes and current station.
