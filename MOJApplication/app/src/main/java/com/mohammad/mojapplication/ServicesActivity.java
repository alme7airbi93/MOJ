package com.mohammad.mojapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mohammad.mojapplication.NotaryServicesFragments.NotaryAddPOne;
import com.mohammad.mojapplication.NotaryServicesFragments.NotaryAddPThree;
import com.mohammad.mojapplication.NotaryServicesFragments.NotaryAddPTwo;
import com.mohammad.mojapplication.NotaryServicesFragments.NotaryAddParty;
import com.mohammad.mojapplication.NotaryServicesFragments.NotaryCamFragment;
import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.Objects.Party;
import com.mohammad.mojapplication.Objects.Service;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.RegistrationFragments.RegStepOne;
import com.mohammad.mojapplication.RegistrationFragments.Welcome;

/**
 * Created by alisa on 11/19/2015.
 */
public class ServicesActivity extends AppCompatActivity implements CommunicatorService
{

    MOJManager mojManager;
    User user;
    private FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);
        startNotaryPageOne();
        String id = getIntent().getStringExtra("userID");
        mojManager = MOJManager.getMOJManager(this);
        user = mojManager.findUserById(id);
    }

    public void startNotaryPageOne()
    {
        NotaryAddPOne notaryAddPOne = new NotaryAddPOne();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.servicesActivityLayout, notaryAddPOne, "NPO");
        transaction.commit();


    }




    @Override
    public void sendToStepTwo(Service service,User user,Party party) {
        NotaryAddPTwo notaryAddPTwo = new NotaryAddPTwo();
        notaryAddPTwo.receiveUser(service,user,party);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.servicesActivityLayout, notaryAddPTwo, "NPT");
        transaction.commit();


        stopStepOne();
    }




    @Override
    public void sendToStepThree(Service service,User user,Party party) {

        NotaryAddPThree notaryAddPThree = new NotaryAddPThree();
        notaryAddPThree.receiveUser(service,user,party);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.servicesActivityLayout, notaryAddPThree, "NPTH");
        transaction.commit();
        stopStepTwo();

    }

    @Override
    public void sendToAdd(int one,int two) {
        NotaryAddParty notaryAddParty = new NotaryAddParty();
        notaryAddParty.receiveExtra(one,two);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.servicesActivityLayout, notaryAddParty, "NAP");
        transaction.commit();

        stopStepOne();
    }

    @Override
    public void backFromAdd(Party party,int one, int two) {

        NotaryAddPOne notaryAddPOne = new NotaryAddPOne();
        notaryAddPOne.receiveExtraFromParty(party, one, two);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.servicesActivityLayout, notaryAddPOne, "NPO");
        transaction.commit();


        stopStepAdd();

    }

    @Override
    public void PartyToCam(Party party, int one, int two) {
        NotaryCamFragment notaryCamFragment = new NotaryCamFragment();
        notaryCamFragment.recieveFromAddParty(party, one, two);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.servicesActivityLayout, notaryCamFragment, "CAM");
        transaction.commit();


        stopStepAdd();
    }

    @Override
    public void CamtoParty(Party party, int one, int two, String picDirFront) {
        NotaryAddParty notaryAddParty = new NotaryAddParty();
        notaryAddParty.receiveExtraFromCam(party, one, two,picDirFront);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.servicesActivityLayout, notaryAddParty, "NPO");
        transaction.commit();


        stopStepAdd();
    }

    @Override
    public void stopStepOne() {
        NotaryAddPOne notaryAddPOne = (NotaryAddPOne) manager.findFragmentByTag("NPO");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(notaryAddPOne);
        transaction.commit();
    }

    @Override
    public void stopStepTwo() {
        NotaryAddPTwo notaryAddPTwo = (NotaryAddPTwo) manager.findFragmentByTag("NPT");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(notaryAddPTwo);
        transaction.commit();
    }

    @Override
    public void stopStepAdd() {
        NotaryAddParty notaryAddParty = (NotaryAddParty) manager.findFragmentByTag("NAP");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(notaryAddParty);
        transaction.commit();
    }

    @Override
    public void stopCam() {
        NotaryCamFragment notaryCamFragment = (NotaryCamFragment) manager.findFragmentByTag("CAM");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(notaryCamFragment);
        transaction.commit();
    }

    @Override
    public void backtoMain(String userid) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("userID", user.getId().toString());
        startActivity(i);
        this.finish();
    }
}
