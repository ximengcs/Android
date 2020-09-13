package com.project.finalwork.listener;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.project.finalwork.BasicInfoActivity;

public class ID_numberInputListener implements TextWatcher {

    private EditText native_place;
    private EditText year;
    private EditText month;
    private EditText day;
    private EditText id_number;

    public ID_numberInputListener( EditText native_place, EditText year, EditText month, EditText day, EditText id_number ) {
        this.id_number = id_number;
        this.native_place = native_place;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String number = id_number.getText().toString();
        if(BasicInfoActivity.nativePlaceService !=null) {
            String nativePlaceInfo = BasicInfoActivity.nativePlaceService.getNativePlaceInfo(number);
            if(nativePlaceInfo!=null) {
                native_place.setText(nativePlaceInfo);
                native_place.setEnabled(false);

                year.setText(BasicInfoActivity.nativePlaceService.getYear(number));
                month.setText(BasicInfoActivity.nativePlaceService.getMonth(number));
                day.setText(BasicInfoActivity.nativePlaceService.getDay(number));

                year.setEnabled(false);
                month.setEnabled(false);
                day.setEnabled(false);
            } else {
                native_place.setText("");
                year.setText("");
                month.setText("");
                day.setText("");
                native_place.setEnabled(true);
                day.setEnabled(true);
                year.setEnabled(true);
                month.setEnabled(true);
            }
        }
    }
}
