package com.mohammad.mojapplication.RegistrationFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mohammad.mojapplication.MOJManager;
import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.R;

/**
 * Created by user on 11/1/2015.
 */
public class RegStepThree extends Fragment
{
    private EditText etUserName, etPass;
    private Button btnFinish;
    private MOJManager mojManager;
    private NIDCard nidCard;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mojManager = MOJManager.getMOJManager(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg_step_three_layout, container, false);


        etPass = (EditText) v.findViewById(R.id.etPass);
        etUserName = (EditText) v.findViewById(R.id.etUser);

        btnFinish = (Button) v.findViewById(R.id.btnFinish);


        return v;
    }

    public void reciveNIDCardObject(NIDCard nidCard)
    {

        this.nidCard = nidCard;
    }
}
