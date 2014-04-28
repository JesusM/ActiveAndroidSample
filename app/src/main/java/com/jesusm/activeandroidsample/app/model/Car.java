package com.jesusm.activeandroidsample.app.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Jesus on 28/04/14.
 */
@Table(name = "car")
public class Car extends Model {
    @Column(name = "description")
    private String description;
    @Column(name = "wheel1")
    private Wheel wheel1;
    @Column(name = "wheel2")
    private Wheel wheel2;
    @Column(name = "wheel3")
    private Wheel wheel3;
    @Column(name = "wheel4")
    private Wheel wheel4;
    @Column(name = "registrationNumber")
    private int registrationNumber;

    public Car() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wheel getWheel1() {
        return wheel1;
    }

    public void setWheel1(Wheel wheel1) {
        this.wheel1 = wheel1;
    }

    public Wheel getWheel2() {
        return wheel2;
    }

    public void setWheel2(Wheel wheel2) {
        this.wheel2 = wheel2;
    }

    public Wheel getWheel3() {
        return wheel3;
    }

    public void setWheel3(Wheel wheel3) {
        this.wheel3 = wheel3;
    }

    public Wheel getWheel4() {
        return wheel4;
    }

    public void setWheel4(Wheel wheel4) {
        this.wheel4 = wheel4;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "description='" + description + '\'' +
                ", wheel1=" + wheel1 +
                ", wheel2=" + wheel2 +
                ", wheel3=" + wheel3 +
                ", wheel4=" + wheel4 +
                ", registrationNumber=" + registrationNumber +
                '}';
    }
}
