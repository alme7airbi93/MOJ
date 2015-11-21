package com.mohammad.mojapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mohammad.mojapplication.NotaryServicesFragments.NotaryAddPOne;
import com.mohammad.mojapplication.NotaryServicesFragments.NotaryAddPThree;
import com.mohammad.mojapplication.NotaryServicesFragments.NotaryAddPTwo;
import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.RegistrationFragments.Welcome;

/**
 * Created by alisa on 11/19/2015.
 */
public class ServicesActivity extends AppCompatActivity implements CommunicatorService
{


    private FragmentManager manager = getSupportFragmentManager();
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_services_list);
        startNotaryPageOne();

    }

    public void startNotaryPageOne()
    {
        NotaryAddPOne notaryAddPOne = new NotaryAddPOne();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.services_list_container, notaryAddPOne, "NPO");
        transaction.commit();
    }




    @Override
    public void sendToStepTwo() {
        NotaryAddPTwo notaryAddPTwo = new NotaryAddPTwo();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.services_list_container, notaryAddPTwo, "NPT");
        transaction.commit();
    }





    @Override
    public void sendTpStepThree() {

        NotaryAddPThree notaryAddPThree = new NotaryAddPThree();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.services_list_container, notaryAddPThree, "NPTH");
        transaction.commit();

    }

    @Override
    public void backtoMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
