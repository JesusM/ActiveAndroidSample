package com.jesusm.activeandroidsample.app.ui.activities.fragments;

/**
 * Created by Jesus on 28/04/14.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jesusm.activeandroidsample.app.R;
import com.jesusm.activeandroidsample.app.model.Car;
import com.jesusm.activeandroidsample.app.model.Wheel;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceHolderFragment extends Fragment {

    public static final int STATE_EDIT = 1;
    public static final int STATE_SAVE = 2;

    private mainCallback mListener;

    @InjectView(R.id.car_info_wheels_1)
    EditText wheel1;
    @InjectView(R.id.car_info_wheels_2)
    EditText wheel2;
    @InjectView(R.id.car_info_wheels_3)
    EditText wheel3;
    @InjectView(R.id.car_info_wheels_4)
    EditText wheel4;
    @InjectView(R.id.car_info_description)
    EditText description;
    private int state = STATE_EDIT;
    private MenuItem updateMenuItem;

    public static PlaceHolderFragment newInstance() {
        return new PlaceHolderFragment();
    }

    public PlaceHolderFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (mainCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement BillFragmentCallback");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, rootView);
        updateUI(getState());
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        updateMenuItem = menu.getItem(0);
        updateMenuItemUI();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_car) {
            if (getState() == STATE_EDIT) {
                editData();
            } else {
                saveCar();

            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void editData() {
        setState(STATE_SAVE);
        updateUI();
    }

    private void saveCar() {

        setState(STATE_EDIT);
        updateUI();
        if (checkEditText()) {
            mListener.saveCar(createCarInfo());
        } else {
            Crouton.makeText(getActivity(), "Please, fill all data", Style.ALERT).show();
        }
    }

    private Car createCarInfo() {
        Car car = new Car();
        car.setDescription(description.getText().toString());
        car.setWheel1(new Wheel("wheel1", Integer.parseInt(wheel1.getText().toString())));
        car.setWheel2(new Wheel("wheel2", Integer.parseInt(wheel2.getText().toString())));
        car.setWheel3(new Wheel("wheel3", Integer.parseInt(wheel3.getText().toString())));
        car.setWheel4(new Wheel("wheel4", Integer.parseInt(wheel4.getText().toString())));
        return car;
    }

    private boolean checkEditText() {
        return !TextUtils.isEmpty(wheel1.getText())
                && !TextUtils.isEmpty(wheel2.getText())
                && !TextUtils.isEmpty(wheel3.getText())
                && !TextUtils.isEmpty(wheel4.getText())
                && !TextUtils.isEmpty(description.getText());

    }

    private void updateUI() {
        updateMenuItemUI();
        updateUI(getState());
    }

    private void updateMenuItemUI() {
        if (getState() == STATE_EDIT) {
            updateMenuItem.setTitle(getString(R.string.edit));

        } else {
            updateMenuItem.setTitle(getString(R.string.save));
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListener.onViewCreated();
    }

    public void cardReaded(Car car) {
        wheel1.setText(Integer.toString(car.getWheel1().getRadius()));
        wheel2.setText(Integer.toString(car.getWheel2().getRadius()));
        wheel3.setText(Integer.toString(car.getWheel3().getRadius()));
        wheel4.setText(Integer.toString(car.getWheel4().getRadius()));
        description.setText(car.getDescription());
    }

    public void updateUI(int state) {
        this.state = state;
        updateEditText();
    }

    private void updateEditText() {
        wheel1.setEnabled(state != STATE_EDIT);
        wheel2.setEnabled(state != STATE_EDIT);
        wheel3.setEnabled(state != STATE_EDIT);
        wheel4.setEnabled(state != STATE_EDIT);
        description.setEnabled(state != STATE_EDIT);
    }

    public interface mainCallback {
        void onViewCreated();

        void saveCar(Car carInfo);
    }
}
