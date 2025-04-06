package com.example.btl_qlsv.Settings;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.btl_qlsv.R;

public class SettingsActivity extends TabActivity {

    TabHost tabHost;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);




        setControl();
        setEvent();

    }



    private void setControl() {
        tabHost = (TabHost) getTabHost();
    }


    private void setEvent() {


        tabHost.setup();

        TabHost.TabSpec specAccount = tabHost.newTabSpec("Tài khoản");
        Intent accountIntent = new Intent(SettingsActivity.this, SettingsAccountActivity.class);
        specAccount.setIndicator("Tài khoản");
        specAccount.setContent(accountIntent);
        tabHost.addTab(specAccount);

        TabHost.TabSpec spec = tabHost.newTabSpec("Ứng dụng");
        Intent appicationIntent = new Intent(SettingsActivity.this, SettingsApplicationActivity.class);
        spec.setIndicator("Ứng dụng");
        spec.setContent(appicationIntent);
        tabHost.addTab(spec);
    }


}
