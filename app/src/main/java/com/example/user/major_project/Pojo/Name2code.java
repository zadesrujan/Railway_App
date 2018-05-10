
package com.example.user.major_project.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name2code {

    @SerializedName("response_code")
    @Expose
    private long responseCode;
    @SerializedName("debit")
    @Expose
    private long debit;
    @SerializedName("stations")
    @Expose
    private List<NameStation> stations = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Name2code() {
    }

    /**
     * 
     * @param responseCode
     * @param stations
     * @param debit
     */
    public Name2code(long responseCode, long debit, List<NameStation> stations) {
        super();
        this.responseCode = responseCode;
        this.debit = debit;
        this.stations = stations;
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

    public List<NameStation> getStations() {
        return stations;
    }

    public void setStations(List<NameStation> stations) {
        this.stations = stations;
    }

}
//used getters and setters for debit,response code,list of name stations.
