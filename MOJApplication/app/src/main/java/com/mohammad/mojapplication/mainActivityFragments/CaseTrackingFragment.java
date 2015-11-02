package com.mohammad.mojapplication.mainActivityFragments;

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
public class CaseTrackingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.case_tracking_fragment_layout,container,false);
    }
}
