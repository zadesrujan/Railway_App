
package com.example.user.major_project.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Route implements Parcelable {

    @SerializedName("station")
    @Expose
    private Station station;
    @SerializedName("has_arrived")
    @Expose
    private boolean hasArrived;
    @SerializedName("actarr")
    @Expose
    private String actarr;
    @SerializedName("actdep")
    @Expose
    private String actdep;
    @SerializedName("distance")
    @Expose
    private long distance;
    @SerializedName("latemin")
    @Expose
    private long latemin;
    @SerializedName("schdep")
    @Expose
    private String schdep;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("scharr")
    @Expose
    private String scharr;
    @SerializedName("scharr_date")
    @Expose
    private String scharrDate;
    @SerializedName("day")
    @Expose
    private long day;
    @SerializedName("actarr_date")
    @Expose
    private String actarrDate;
    @SerializedName("has_departed")
    @Expose
    private boolean hasDeparted;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Route() {
    }

    /**
     * 
     * @param hasArrived
     * @param scharr
     * @param distance
     * @param actarrDate
     * @param status
     * @param station
     * @param actarr
     * @param scharrDate
     * @param schdep
     * @param latemin
     * @param actdep
     * @param day
     * @param hasDeparted
     */
    public Route(Station station, boolean hasArrived, String actarr, String actdep, long distance, long latemin, String schdep, String status, String scharr, String scharrDate, long day, String actarrDate, boolean hasDeparted) {
        super();
        this.station = station;
        this.hasArrived = hasArrived;
        this.actarr = actarr;
        this.actdep = actdep;
        this.distance = distance;
        this.latemin = latemin;
        this.schdep = schdep;
        this.status = status;
        this.scharr = scharr;
        this.scharrDate = scharrDate;
        this.day = day;
        this.actarrDate = actarrDate;
        this.hasDeparted = hasDeparted;
    }

    public Route(String scharr, String actarr, String schdep, String actdep, long latemin, long distance) {
        this.actarr = actarr;
        this.actdep = actdep;
        this.distance = distance;
        this.latemin = latemin;
        this.schdep = schdep;
        this.scharr = scharr;
    }

    public Route(Parcel in) {
        this.scharr = in.readString();
        this.actarr = in.readString();
        this.schdep = in.readString();
        this.actdep = in.readString();
        this.latemin = in.readLong();
        this.distance = in.readLong();


    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public boolean isHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    public String getActarr() {
        return actarr;
    }

    public void setActarr(String actarr) {
        this.actarr = actarr;
    }

    public String getActdep() {
        return actdep;
    }

    public void setActdep(String actdep) {
        this.actdep = actdep;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public long getLatemin() {
        return latemin;
    }

    public void setLatemin(long latemin) {
        this.latemin = latemin;
    }

    public String getSchdep() {
        return schdep;
    }

    public void setSchdep(String schdep) {
        this.schdep = schdep;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScharr() {
        return scharr;
    }

    public void setScharr(String scharr) {
        this.scharr = scharr;
    }

    public String getScharrDate() {
        return scharrDate;
    }

    public void setScharrDate(String scharrDate) {
        this.scharrDate = scharrDate;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public String getActarrDate() {
        return actarrDate;
    }

    public void setActarrDate(String actarrDate) {
        this.actarrDate = actarrDate;
    }

    public boolean isHasDeparted() {
        return hasDeparted;
    }

    public void setHasDeparted(boolean hasDeparted) {
        this.hasDeparted = hasDeparted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(getStation().getName());
        dest.writeString(getScharr());
        dest.writeString(getActarr());
        dest.writeString(getSchdep());
        dest.writeString(getActdep());
        dest.writeInt((int)getLatemin());
        dest.writeInt((int)getDistance());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Route createFromParcel(Parcel in) {
            return new Route(in);
        }

        public Route[] newArray(int size) {
            return new Route[size];
        }
    };
}
//used getters and setters for actual arrival,c]scheduled arrival,actual departure,scheduled departure,day,status,late minutes and distance.
