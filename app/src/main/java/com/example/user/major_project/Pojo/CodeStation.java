
package com.example.user.major_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CodeStation {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lng")
    @Expose
    private double lng;
    @SerializedName("lat")
    @Expose
    private double lat;

    /**
     * No args constructor for use in serialization
     *
     */
    public CodeStation() {
    }

    /**
     *
     * @param name
     * @param lng
     * @param code
     * @param lat
     */
    public CodeStation(String code, String name, double lng, double lat) {
        super();
        this.code = code;
        this.name = name;
        this.lng = lng;
        this.lat = lat;
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

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

}
//used getters and setters for code,name,lng and for lat purpose.
