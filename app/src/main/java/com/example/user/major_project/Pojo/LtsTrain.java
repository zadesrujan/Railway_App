
package com.example.user.major_project.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LtsTrain {

    @SerializedName("days")
    @Expose
    private List<Day> days = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("classes")
    @Expose
    private List<Class> classes = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LtsTrain() {
    }

    /**
     * 
     * @param classes
     * @param days
     * @param name
     * @param number
     */
    public LtsTrain(List<Day> days, String name, String number, List<Class> classes) {
        super();
        this.days = days;
        this.name = name;
        this.number = number;
        this.classes = classes;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

}
//used getters and setters for list of days,list of class,number and name.