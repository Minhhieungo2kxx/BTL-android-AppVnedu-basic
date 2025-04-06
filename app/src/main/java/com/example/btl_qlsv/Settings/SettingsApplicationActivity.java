package com.example.btl_qlsv.Settings;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import com.example.btl_qlsv.HomeActivity;
import com.example.btl_qlsv.R;

public class SettingsApplicationActivity extends AppCompatActivity {

    SwitchCompat switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Đặt theme đúng trước khi setContentView
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_STDManager_Dark);
        } else {
            setTheme(R.style.Theme_STDManager);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_application);

        setControl();
        setEvent();
    }

    private void setControl() {
        switchButton = findViewById(R.id.darkModeSwitch);
    }

    private void setEvent() {
        // Set trạng thái ban đầu của switch
         if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            switchButton.setChecked(true);
        } else {
            switchButton.setChecked(false);
        }

        //  Bắt sự kiện chuyển đổi Dark/Light mode
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!switchButton.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

                // Gọi restart app nhẹ nhàng bằng cách chuyển lại MainActivity
                Intent intent = new Intent(SettingsApplicationActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}