
package com.example.user.major_project.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassesR {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("available")
    @Expose
    private String available;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClassesR() {
    }

    /**
     * 
     * @param name
     * @param available
     * @param code
     */
    public ClassesR(String code, String name, String available) {
        super();
        this.code = code;
        this.name = name;
        this.available = available;
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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

}
//used getters and setters for getting the code,name and available and also we set it too.
