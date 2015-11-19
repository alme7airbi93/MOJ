package com.mohammad.mojapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mohammad.mojapplication.NotaryServicesFragments.NotaryAddPOne;

/**
 * Created by alisa on 11/19/2015.
 */
public class ServicesActivity extends AppCompatActivity
{


    private FragmentManager manager = getSupportFragmentManager();
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_services_list);
        startServicesListfragment();

    }

    public void startServicesListfragment()
    {
        NotaryAddPOne notaryAddPOne = new NotaryAddPOne();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.services_list_container, notaryAddPOne, "WLC");
        transaction.commit();
    }
}
