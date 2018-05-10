package com.example.user.major_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Class {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("available")
    @Expose
    private String available;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Class() {
    }

    /**
     * 
     * @param available
     * @param code
     */
    public Class(String code, String available) {
        super();
        this.code = code;
        this.available = available;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

}
//used getters and setters for code and for available
