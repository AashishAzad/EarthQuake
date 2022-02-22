package com.vidyakalkendra.quakeapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Earthquake {

    private double magnitude;
    private String url;
    private String location;
    private long time;

    public Earthquake(double magnitude, String url, String location, long time) {
        this.magnitude = magnitude;
        this.url = url;
        this.location = location;
        this.time = time;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getUrl() {
        return url;
    }

    public String getLocation() {
        return location;
    }

    public long getTime() {
        return time;
    }

}
