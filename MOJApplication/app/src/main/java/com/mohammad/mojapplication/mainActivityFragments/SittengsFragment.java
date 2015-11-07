package com.mohammad.mojapplication.mainActivityFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.R;

/**
 * Created by user on 10/31/2015.
 */
public class SittengsFragment extends Fragment {

    private User logedInUser;

    public void reciveUser(User user)
    {
        this.logedInUser = user;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sittengs_fragment_layout,container,false);
    }
}
