package com.mohammad.mojapplication.RegistrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mohammad.mojapplication.Communicator;
import com.mohammad.mojapplication.R;

/**
 * Created by user on 11/5/2015.
 */
public class Welcome extends Fragment
{

    Button btnReg;
    Button btnLog;
    Communicator comm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);

        btnReg = (Button) v.findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                comm = (Communicator) getActivity();
                comm.startStepOne();
                comm.stopWelcomeFragment();


            }
        });

        return v;
    }
}
