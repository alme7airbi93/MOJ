package com.mohammad.mojapplication.NotaryServicesFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mohammad.mojapplication.CommunicatorService;
import com.mohammad.mojapplication.R;

/**
 * Created by alisa on 11/19/2015.
 */
public class NotaryAddPTwo extends Fragment {


    EditText etPin;
    Button btnNext,btnPicFront,btnPicBack;

    CommunicatorService communicatorService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_services_pg_two, container, false);

        etPin = (EditText) v.findViewById(R.id.etPinServ);
        btnPicBack = (Button) v.findViewById(R.id.btnpicBackStep2);
        btnPicFront = (Button) v.findViewById(R.id.btnPicFrontStep2);
        btnNext = (Button) v.findViewById(R.id.btnServNextSecond);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                communicatorService.sendTpStepThree();
            }
        });


        return v;
    }

}


