package com.example.user.major_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FromStation {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FromStation() {
    }

    /**
     * 
     * @param name
     * @param lng
     * @param code
     * @param lat
     */
    public FromStation(String code, String name, double lat, double lng) {
        super();
        this.code = code;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

}
//used getters and setters for lat,long,code and name.
