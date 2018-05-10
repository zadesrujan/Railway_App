package com.example.user.major_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("response_code")
    @Expose
    private long responseCode;
    @SerializedName("debit")
    @Expose
    private long debit;
    @SerializedName("from_station")
    @Expose
    private FromStation fromStation;
    @SerializedName("to_station")
    @Expose
    private ToStation toStation;
    @SerializedName("train")
    @Expose
    private Train train;
    @SerializedName("quota")
    @Expose
    private Quota quota;
    @SerializedName("journey_class")
    @Expose
    private JourneyClass journeyClass;
    @SerializedName("fare")
    @Expose
    private double fare;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Main() {
    }

    /**
     * 
     * @param responseCode
     * @param quota
     * @param fare
     * @param train
     * @param toStation
     * @param debit
     * @param journeyClass
     * @param fromStation
     */
    public Main(long responseCode, long debit, FromStation fromStation, ToStation toStation, Train train, Quota quota, JourneyClass journeyClass, double fare) {
        super();
        this.responseCode = responseCode;
        this.debit = debit;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.train = train;
        this.quota = quota;
        this.journeyClass = journeyClass;
        this.fare = fare;
    }

    public long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(long responseCode) {
        this.responseCode = responseCode;
    }

    public long getDebit() {
        return debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public FromStation getFromStation() {
        return fromStation;
    }

    public void setFromStation(FromStation fromStation) {
        this.fromStation = fromStation;
    }

    public ToStation getToStation() {
        return toStation;
    }

    public void setToStation(ToStation toStation) {
        this.toStation = toStation;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    public JourneyClass getJourneyClass() {
        return journeyClass;
    }

    public void setJourneyClass(JourneyClass journeyClass) {
        this.journeyClass = journeyClass;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

}
//used getters and setters for debit,response code,tarin,Journey class,fare details,quota details,from and to station.
