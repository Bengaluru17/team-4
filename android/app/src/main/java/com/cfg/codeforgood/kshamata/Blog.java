package com.cfg.codeforgood.kshamata;

/**
 * Created by test on 09-07-2017.
 */

public class Blog {
    private String fullName;
    private String location;

    public Blog(){

    }

    public Blog(String fullName, String location){
        this.fullName=fullName;
        this.location=location;

    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
