package com.mohammad.mojapplication.mainActivityFragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mohammad.mojapplication.MainActivity;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.R;

/**
 * Created by user on 11/1/2015.
 */
public class CaseTrackingFragment extends Fragment {

    private User logedInUser;
    private TextView tvUserName;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.case_tracking_fragment_layout,container,false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        logedInUser = MainActivity.user;
        tvUserName = (TextView)getActivity().findViewById(R.id.tvUserName);
        tvUserName.setText(logedInUser.getMobile().toString());

    }
}
