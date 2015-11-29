package com.mohammad.mojapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.mohammad.mojapplication.Objects.NIDCard;
import com.mohammad.mojapplication.Objects.User;
import com.mohammad.mojapplication.mainActivityFragments.CaseTrackingFragment;
import com.mohammad.mojapplication.mainActivityFragments.NewsFragment;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements CommunicatorMain{
    private MOJManager mojManager;
    public LinearLayout tab1;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        return (keyCode == KeyEvent.KEYCODE_BACK ? true : super.onKeyDown(keyCode, event));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHostAdding();



    }


    private void tabHostAdding()
    {



        tab1= (LinearLayout)findViewById(R.id.tab1);
        final TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        final TabHost.TabSpec newsTab = tabHost.newTabSpec("News");
        newsTab.setContent(R.id.tab1);
        newsTab.setIndicator("الاخبار");
        tabHost.addTab(newsTab);


        TabHost.TabSpec servicesTab = tabHost.newTabSpec("services");
        servicesTab.setContent(R.id.tab2);
        servicesTab.setIndicator("الخدمات");
        tabHost.addTab(servicesTab);

        TabHost.TabSpec caseTrackingTab  = tabHost.newTabSpec("caseTracking");
        caseTrackingTab.setContent(R.id.tab3);
        caseTrackingTab.setIndicator("ملفي");
        tabHost.addTab(caseTrackingTab);

        TabHost.TabSpec settingTab = tabHost.newTabSpec("settings");
        settingTab.setContent(R.id.tab4);
        settingTab.setIndicator("إعدادات");
        tabHost.addTab(settingTab);





        tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#18000001"));
        tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#FFFFFF"));
        tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#FFFFFF"));
        tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.parseColor("#FFFFFF"));


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabHost.getCurrentTab() == 0)
                {
                    //resetColor(tabHost);
                    tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#18000001"));
                    tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.parseColor("#FFFFFF"));



                    Log.d("OnTABList","test1");
                }
                if(tabHost.getCurrentTab() == 1)
                {
                    //resetColor(tabHost);
                    tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#18000001"));
                    tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.parseColor("#FFFFFF"));



                    Log.d("OnTABList","test2");
                }
                if(tabHost.getCurrentTab() == 2)
                {
                    //resetColor(tabHost);
                    tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#18000001"));
                    tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.parseColor("#FFFFFF"));


                    Log.d("OnTABList","test3");
                }
                if(tabHost.getCurrentTab() == 3)
                {
                    //resetColor(tabHost);
                    tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.parseColor("#18000001"));
                    tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#FFFFFF"));
                    tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor("#FFFFFF"));


                    Log.d("OnTABList","test4");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void sendToStepOne() {
        Intent i = new Intent(MainActivity.this, ServicesActivity.class);
        Log.d("123", "miaiiiiin---------------------------------------------");

        i.putExtra("userID", getIntent().getStringExtra("userID"));
        startActivity(i);
        this.finish();

    }

}
