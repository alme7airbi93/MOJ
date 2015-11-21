package com.mohammad.mojapplication.NotaryServicesFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.mohammad.mojapplication.CommunicatorService;
import com.mohammad.mojapplication.R;

/**
 * Created by alisa on 11/19/2015.
 */
public class NotaryAddParty extends Fragment {

    Button btnFirstParty,btnSecondParty,btnNext;
    Spinner spLoc, spDocType;
    CommunicatorService communicatorService;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_services_pg_one, container, false);

        spLoc = (Spinner) v.findViewById(R.id.spLocation);
        spDocType = (Spinner) v.findViewById(R.id.spDocType);
        btnFirstParty = (Button) v.findViewById(R.id.btnAddParty);
        btnSecondParty = (Button) v.findViewById(R.id.btnAddParty2);
        btnNext = (Button) v.findViewById(R.id.btnServNextFirst);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                communicatorService.sendToStepTwo();

            }
        });

        return v;
    }

}


