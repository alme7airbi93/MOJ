package com.mohammad.mojapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.RegistrationFragments.Login;
import com.mohammad.mojapplication.RegistrationFragments.RegStepOne;
import com.mohammad.mojapplication.RegistrationFragments.RegStepThree;
import com.mohammad.mojapplication.RegistrationFragments.RegStepTwo;
import com.mohammad.mojapplication.RegistrationFragments.Welcome;

import java.io.Serializable;

public class RegistrationActivity extends AppCompatActivity implements Communicator
{

    private User user;
     private FragmentManager manager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        startWelcomeFragment();


    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        savedInstanceState.putSerializable("123", (Serializable) user);
    }

    @Override
    public void sendUsertoMainActivity(User user) {
        this.user = user;
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        this.finish();
    }


    @Override
    public void sendData(String string) {

        RegStepTwo regStepTwo = new RegStepTwo();
        regStepTwo.reciveIDNumber(string);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.registrationActivityLayout,regStepTwo,"FS2");
        transaction.commit();
        stopStepOne();




    }

    @Override
    public void sendNIDcardObject(NIDCard nidCard) {
        RegStepThree regStepThree = new RegStepThree();
        regStepThree.reciveNIDCardObject(nidCard);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.registrationActivityLayout, regStepThree, "FS3");
        transaction.commit();
        stopStepTwo();

    }

    @Override
    public void startWelcomeFragment()
    {
        Welcome welcome = new Welcome();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.registrationActivityLayout, welcome, "WLC");
        transaction.commit();
    }
    @Override
    public void stopWelcomeFragment() {
        Welcome welcome = (Welcome) manager.findFragmentByTag("WLC");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(welcome);
        transaction.commit();
    }


    @Override
    public void startStepOne()
    {
        RegStepOne regStepOne = new RegStepOne();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.registrationActivityLayout, regStepOne, "FS1");
        transaction.commit();
    }

    @Override
    public void startLogin()
    {
        Login login = new Login();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.registrationActivityLayout, login, "LOG");
        transaction.commit();

    }

    public void stopStepOne() {
        RegStepOne regStepOne = (RegStepOne) manager.findFragmentByTag("FS1");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(regStepOne);
        transaction.commit();
    }
    public void stopStepTwo() {
        RegStepTwo regStepTwo = (RegStepTwo)manager.findFragmentByTag("FS2");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(regStepTwo);
        transaction.commit();
    }

}
