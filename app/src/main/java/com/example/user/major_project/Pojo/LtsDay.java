
package com.example.user.major_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LtsDay {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("runs")
    @Expose
    private String runs;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LtsDay() {
    }

    /**
     * 
     * @param runs
     * @param code
     */
    public LtsDay(String code, String runs) {
        super();
        this.code = code;
        this.runs = runs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

}
//used getters and setters for code and runs.
