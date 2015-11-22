package com.mohammad.mojapplication.NotaryServicesFragments;

import android.os.Bundle;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mohammad.mojapplication.CommunicatorService;
import com.mohammad.mojapplication.MOJManager;
import com.mohammad.mojapplication.Objects.Party;
import com.mohammad.mojapplication.Objects.Service;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.R;

import java.util.Date;

/**
 * Created by alisa on 11/19/2015.
 */
public class NotaryAddPOne extends Fragment {

    Button btnFirstParty,btnSecondParty,btnNext;
    Spinner spLoc, spDocType;
    CommunicatorService communicatorService;
    MOJManager mojManager;
    Party party,party2;
    int one = 0, two = 0;



    public void receiveExtraFromParty(Party party,int one,int two) {


        this.party = party;
        this.one = one;
        this.two = two;

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("123", "insiiiiiiiiiiiiiiiiiiiiiidesssssssssssssssssssss1111---------------------------------------------");
        mojManager = MOJManager.getMOJManager(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_services_pg_one, container, false);
        communicatorService = (CommunicatorService) getActivity();

        spLoc = (Spinner) v.findViewById(R.id.spLocation);
        spDocType = (Spinner) v.findViewById(R.id.spDocType);
        btnFirstParty = (Button) v.findViewById(R.id.btnAddParty);
        btnSecondParty = (Button) v.findViewById(R.id.btnAddParty2);
        btnNext = (Button) v.findViewById(R.id.btnServNextFirst);




        spLoc.setSelection(one);
        spDocType.setSelection(two);


        Log.d("123", "insiiiiiiiiiiiiiiiiiiiiiide222222222222---------------------------------------------");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = mojManager.findUserById(getActivity().getIntent().getStringExtra("userID"));

                Service service = new Service(user.getId(), spDocType.getSelectedItem().toString(),
                        spLoc.getSelectedItem().toString(), new Date(), "Pending", party.getPartyID(), party.getPartyID());
                communicatorService.sendToStepTwo(service,user,party);

            }
        });
        btnFirstParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                communicatorService.sendToAdd(spLoc.getSelectedItemPosition(),spDocType.getSelectedItemPosition());

            }
        });

        return v;
    }


}


