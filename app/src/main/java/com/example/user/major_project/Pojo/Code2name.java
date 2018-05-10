
package com.example.user.major_project.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Code2name {

    @SerializedName("response_code")
    @Expose
    private long responseCode;
    @SerializedName("debit")
    @Expose
    private long debit;
    @SerializedName("stations")
    @Expose
    private List<CodeStation> stations = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Code2name() {
    }

    /**
     * 
     * @param responseCode
     * @param stations
     * @param debit
     */
    public Code2name(long responseCode, long debit, List<CodeStation> stations) {
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

    public List<CodeStation> getStations() {
        return stations;
    }

    public void setStations(List<CodeStation> stations) {
        this.stations = stations;
    }

}
//used getters and setters for response code,debit purpose and station list.
