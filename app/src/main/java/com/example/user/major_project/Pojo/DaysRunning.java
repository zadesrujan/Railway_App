
package com.example.user.major_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DaysRunning {

    @SerializedName("runs")
    @Expose
    private String runs;
    @SerializedName("code")
    @Expose
    private String code;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DaysRunning() {
    }

    /**
     * 
     * @param code
     * @param runs
     */
    public DaysRunning(String runs, String code) {
        super();
        this.runs = runs;
        this.code = code;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
//used getters and setters for code and runs purpose.
