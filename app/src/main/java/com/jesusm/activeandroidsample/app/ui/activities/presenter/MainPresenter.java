package com.jesusm.activeandroidsample.app.ui.activities.presenter;

import com.jesusm.activeandroidsample.app.model.Car;
import com.jesusm.activeandroidsample.app.persistent.PersistentAccess;
import com.squareup.otto.Bus;

/**
 * Created by Jesus on 28/04/14.
 */
public class MainPresenter {


    private PersistentAccess persistentAccess;
    private MainView mainView;
    private Bus bus;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        bus = new Bus();
        persistentAccess = PersistentAccess.getInstance();
    }

    public void resume() {
        bus.register(this);
    }

    public void pause() {
        bus.unregister(this);
    }


    public void readCarInfo() {
        Car car = persistentAccess.readCarInfo();
        mainView.carReaded(car);
    }

    public void updateCarInfo(Car car) {
        Long savedId = persistentAccess.saveCarInfo(car);
        mainView.onCarSaved(savedId);
    }

    public interface MainView {
        void carReaded(Car car);

        void onCarSaved(Long savedId);
    }

}
