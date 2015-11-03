package com.mohammad.mojapplication.RegistrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohammad.mojapplication.R;

/**
 * Created by user on 11/1/2015.
 */
public class RegStepTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg_step_two_layout, container, false);
        return v;
    }
}
