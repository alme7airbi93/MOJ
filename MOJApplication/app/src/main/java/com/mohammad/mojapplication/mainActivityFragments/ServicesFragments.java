package com.mohammad.mojapplication.mainActivityFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mohammad.mojapplication.Communicator;
import com.mohammad.mojapplication.CommunicatorMain;
import com.mohammad.mojapplication.CommunicatorService;
import com.mohammad.mojapplication.MOJManager;
import com.mohammad.mojapplication.MainActivity;
import com.mohammad.mojapplication.R;
import com.mohammad.mojapplication.ServicesActivity;

/**
 * Created by user on 10/31/2015.
 */


public class ServicesFragments extends Fragment{

    Button btnnotary;
    private CommunicatorMain communicator;
    private MOJManager mojManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.services_fragment_layout,container,false);

        communicator = (CommunicatorMain) getActivity();
        btnnotary = (Button) v.findViewById(R.id.btnNotary);

        btnnotary.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        communicator.sendToStepOne("123");

    }
});

        return v;
    }
}
