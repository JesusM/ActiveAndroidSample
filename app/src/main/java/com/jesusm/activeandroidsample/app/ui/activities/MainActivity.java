package com.jesusm.activeandroidsample.app.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.jesusm.activeandroidsample.app.R;
import com.jesusm.activeandroidsample.app.model.Car;
import com.jesusm.activeandroidsample.app.ui.activities.fragments.PlaceHolderFragment;
import com.jesusm.activeandroidsample.app.ui.activities.presenter.MainPresenter;


public class MainActivity extends ActionBarActivity implements MainPresenter.MainView,
        PlaceHolderFragment.mainCallback {


    MainPresenter mainPresenter;
    private PlaceHolderFragment mainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        initFragment(savedInstanceState);
    }

    private void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mainFragment = PlaceHolderFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, mainFragment)
                    .commit();
        } else {
            mainFragment =
                    (PlaceHolderFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        }

    }

    private void initPresenter() {
        mainPresenter = new MainPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mainPresenter.pause();
    }


    @Override
    public void carReaded(Car car) {
        mainFragment.cardReaded(car);
    }

    @Override
    public void onCarSaved(Long savedId) {
        Toast.makeText(getApplicationContext(),
                savedId > 0 ? "Info actualizada" : "Ha habido un error al guardar los datos",
                Toast.LENGTH_LONG).show();
        mainPresenter.readCarInfo();
    }

    @Override
    public void onViewCreated() {
        mainPresenter.readCarInfo();
    }

    @Override
    public void saveCar(Car carInfo) {
        mainPresenter.updateCarInfo(carInfo);
    }


}
