package com.mohammad.mojapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.RegistrationFragments.RegStepOne;
import com.mohammad.mojapplication.RegistrationFragments.RegStepThree;
import com.mohammad.mojapplication.RegistrationFragments.RegStepTwo;
import com.mohammad.mojapplication.RegistrationFragments.Welcome;

public class RegistrationActivity extends AppCompatActivity implements Communicator
{


     private FragmentManager manager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
       startWelcomeFragment();


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
        transaction.add(R.id.registrationActivityLayout, welcome, "wlc");
        transaction.commit();
    }
    @Override
    public void stopWelcomeFragment() {
        Welcome welcome = (Welcome) manager.findFragmentByTag("wlc");
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
