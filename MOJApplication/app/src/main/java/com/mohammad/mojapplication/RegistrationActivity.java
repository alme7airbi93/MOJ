package com.mohammad.mojapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.mohammad.mojapplication.RegistrationFragments.Communicator;
import com.mohammad.mojapplication.RegistrationFragments.RegStepOne;
import com.mohammad.mojapplication.RegistrationFragments.RegStepTwo;

public class RegistrationActivity extends AppCompatActivity implements Communicator {


     private FragmentManager manager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        startStepOne();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    public void startStepOne()
    {
        RegStepOne regStepOne = new RegStepOne();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.registrationActivityLayout, regStepOne, "FS1");
        transaction.commit();
    }

    public void stopStepOne() {
        RegStepOne regStepOne = (RegStepOne) manager.findFragmentByTag("FS1");
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(regStepOne);
        transaction.commit();
    }

}
