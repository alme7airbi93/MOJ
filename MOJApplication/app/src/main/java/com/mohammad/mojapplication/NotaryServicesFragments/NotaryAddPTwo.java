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
import com.mohammad.mojapplication.MOJManager;
import com.mohammad.mojapplication.Objects.Party;
import com.mohammad.mojapplication.Objects.Service;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.R;

/**
 * Created by alisa on 11/19/2015.
 */
public class NotaryAddPTwo extends Fragment {


    EditText etPin;
    Button btnNext,btnPicFront,btnPicBack;
    MOJManager mojManager;
    Party party;
    Service service;
    User user;
    CommunicatorService communicatorService;

    public void receiveUser(Service service,User user,Party party) {

        this.user = user;
        this.service = service;
        this.party = party;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mojManager = MOJManager.getMOJManager(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_services_pg_two, container, false);

        communicatorService = (CommunicatorService) getActivity();

        etPin = (EditText) v.findViewById(R.id.etPinServ);
        btnPicBack = (Button) v.findViewById(R.id.btnpicBackStep2);
        btnPicFront = (Button) v.findViewById(R.id.btnPicFrontStep2);
        btnNext = (Button) v.findViewById(R.id.btnServNextSecond);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                User userCompare = mojManager.findUserById(user.getId());

                if(etPin.getText().toString().equals(userCompare.getServicePass()))
                {

                    communicatorService.sendToStepThree(service,user, party);

                }


            }
        });


        return v;
    }

}


