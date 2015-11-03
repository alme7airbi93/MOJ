package com.mohammad.mojapplication.RegistrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mohammad.mojapplication.R;

/**
 * Created by user on 11/1/2015.
 */
public class RegStepTwo extends Fragment {

    private Button btnNextSMS;
    private EditText etSMSCode;
    private String IDNumber ;


    public void reciveIDNumber(String idNumber) {

        this.IDNumber = idNumber;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg_step_two_layout, container, false);
        btnNextSMS = (Button)v.findViewById(R.id.btnNextSMS);
        etSMSCode = (EditText) v.findViewById(R.id.etSMS);
        etSMSCode.setText(IDNumber);

        return v;
    }
}
