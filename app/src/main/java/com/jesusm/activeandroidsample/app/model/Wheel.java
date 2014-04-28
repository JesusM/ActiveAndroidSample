package com.jesusm.activeandroidsample.app.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Jesus on 28/04/14.
 */
@Table(name = "wheel")
public class Wheel extends Model{

    @Column(name = "wheelId")
    private String wheelId;

    @Column(name = "radius")
    private int radius;

    public Wheel() {

    }

    public Wheel(String wheelId, int radius){
        this.wheelId = wheelId;
        this.radius = radius;
    }

    public String getWheelId() {
        return wheelId;
    }

    public void setWheelId(String wheelId) {
        this.wheelId = wheelId;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "radius=" + radius;
    }
}
