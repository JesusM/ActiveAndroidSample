package com.jesusm.activeandroidsample.app.persistent;

import com.activeandroid.query.Select;
import com.jesusm.activeandroidsample.app.model.Car;
import com.jesusm.activeandroidsample.app.model.Wheel;

/**
 * Created by Jesus on 28/04/14.
 */
public class PersistentAccess {

    public static PersistentAccess getInstance() {
        return new PersistentAccess();
    }

    private PersistentAccess() {

    }


    public Car readCarInfo() {
        return new Select().from(Car.class).executeSingle();
    }

    public Long saveCarInfo(Car car) {
        Car savedCar = readCarInfo();
        if (savedCar != null) {
            savedCar = updateCar(car, savedCar);
        } else {
            savedCar = car;
            Long wheelSavedId = saveWheel(savedCar.getWheel1());
            wheelSavedId = saveWheel(savedCar.getWheel2());
            wheelSavedId = saveWheel(savedCar.getWheel3());
            wheelSavedId = saveWheel(savedCar.getWheel4());

        }
        return savedCar.save();
    }

    private Long saveWheel(Wheel wheel) {
        return wheel.save();
    }

    private Car updateCar(Car car, Car savedCar) {

        Wheel wheel1 = car.getWheel1();
        Wheel wheel2 = car.getWheel2();
        Wheel wheel3 = car.getWheel3();
        Wheel wheel4 = car.getWheel4();



        Wheel savedWheel1 ;
        Wheel savedWheel2 ;
        Wheel savedWheel3 ;
        Wheel savedWheel4 ;

        savedWheel1 = updateWheel(wheel1);
        savedWheel2 = updateWheel(wheel2);
        savedWheel3 = updateWheel(wheel3);
        savedWheel4 = updateWheel(wheel4);

        savedCar.setWheel1(savedWheel1);
        savedCar.setWheel2(savedWheel2);
        savedCar.setWheel3(savedWheel3);
        savedCar.setWheel4(savedWheel4);

        savedCar.setDescription(car.getDescription());

        return savedCar;
    }

    private Wheel updateWheel(Wheel wheel1) {
        Wheel savedWheel1 = readWheel(wheel1.getWheelId());
        if (savedWheel1 != null) {
            savedWheel1.setRadius(wheel1.getRadius());
            savedWheel1.setWheelId(wheel1.getWheelId());
        } else {
            savedWheel1 = wheel1;
        }
        savedWheel1.save();
        return savedWheel1;
    }

    private Wheel readWheel(String wheelId) {
        return new Select().from(Wheel.class).where("wheelId = ?", wheelId).executeSingle();
    }


}
