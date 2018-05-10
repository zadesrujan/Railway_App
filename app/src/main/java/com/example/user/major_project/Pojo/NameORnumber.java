
package com.example.user.major_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NameORnumber {

    @SerializedName("debit")
    @Expose
    private Long debit;
    @SerializedName("response_code")
    @Expose
    private Long responseCode;
    @SerializedName("train")
    @Expose
    private Trainname train;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NameORnumber() {
    }

    /**
     * 
     * @param responseCode
     * @param train
     * @param debit
     */
    public NameORnumber(Long debit, Long responseCode, Trainname train) {
        super();
        this.debit = debit;
        this.responseCode = responseCode;
        this.train = train;
    }

    public Long getDebit() {
        return debit;
    }

    public void setDebit(Long debit) {
        this.debit = debit;
    }

    public Long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Long responseCode) {
        this.responseCode = responseCode;
    }

    public Trainname getTrain() {
        return train;
    }

    public void setTrain(Trainname train) {
        this.train = train;
    }

}
//used getters and setters for debit,response code and train details.
