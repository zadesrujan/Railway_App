
package com.example.user.major_project.Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trainname {

    @SerializedName("classes")
    @Expose
    private List<ClassesR> classes = null;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("days")
    @Expose
    private List<Day> days = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Trainname() {
    }

    /**
     * 
     * @param classes
     * @param days
     * @param name
     * @param number
     */
    public Trainname(List<ClassesR> classes, String number, String name, List<Day> days) {
        super();
        this.classes = classes;
        this.number = number;
        this.name = name;
        this.days = days;
    }

    public List<ClassesR> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassesR> classes) {
        this.classes = classes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

}
//used getters and setters for list of classes,list of days,name and number.
