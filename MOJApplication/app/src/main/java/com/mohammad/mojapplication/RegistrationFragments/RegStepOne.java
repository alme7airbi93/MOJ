package com.mohammad.mojapplication.RegistrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mohammad.mojapplication.R;

/**
 * Created by user on 11/1/2015.
 */
public class RegStepOne extends Fragment {

    private TextView tvID;
    private EditText etID;
    private Button btnNextID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg_step_one_layout,container,false);
        tvID = (TextView)v.findViewById(R.id.tvID);
        etID = (EditText)v.findViewById(R.id.etNID);
        btnNextID = (Button)v.findViewById(R.id.btnNextID);




        return v;


    }

}
