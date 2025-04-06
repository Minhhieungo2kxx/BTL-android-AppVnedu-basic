package com.example.btl_qlsv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_qlsv.Classroom.ClassroomActivity;
import com.example.btl_qlsv.Event.EventActivity;
import com.example.btl_qlsv.Score.ScoreSubjectActivity;
import com.example.btl_qlsv.Settings.SettingsAccountActivity;
import com.example.btl_qlsv.Settings.SettingsActivity;
import com.example.btl_qlsv.Statistic.StatisticActivity;
import com.example.btl_qlsv.Subject.SubjectActivity;

public class HomeActivity extends AppCompatActivity {
    private App appState;

    ImageButton buttonHomeStatistic,
            buttonHomeClassroom,
            buttonHomeSubject,
            buttonHomeEvent,
            buttonHomeScore,
            buttonHomeAccount,
            buttonSetting,
            buttonLogout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        appState = (App) getApplication();

        setControl();
        setEvent();
    }

    private void setControl()
    {
        buttonHomeStatistic = findViewById(R.id.buttonHomeStatistic);
        buttonHomeClassroom = findViewById(R.id.buttonHomeClassroom);

        buttonHomeSubject = findViewById(R.id.buttonHomeSubject);
        buttonHomeEvent = findViewById(R.id.buttonHomeEvent);

        buttonHomeScore = findViewById(R.id.buttonHomeScore);
        buttonHomeAccount = findViewById(R.id.buttonHomeAccount);
        buttonSetting = findViewById(R.id.buttonSetting);
        buttonLogout = findViewById(R.id.buttonLogout);
    }


    @SuppressLint("RestrictedApi")
    private void setEvent(){

        /*Step 1*/
        buttonHomeStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, StatisticActivity.class);
                startActivity(intent);
            }
        });

        /*Step 2*/
        buttonHomeClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ClassroomActivity.class);
                startActivity(intent);
            }
        });

        buttonHomeSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SubjectActivity.class);
                startActivity(intent);
            }
        });

        buttonHomeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SettingsAccountActivity.class);
                startActivity(intent);
            }
        });

        buttonHomeScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ScoreSubjectActivity.class);
                startActivity(intent);
            }
        });

        buttonHomeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appState != null && appState.getTeacher() != null) {
                    appState.setTeacher(null);
                }
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                Toast.makeText(HomeActivity.this, "Đăng xuất thành công !", Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish(); // optional: thoát luôn khỏi HomeActivity
            }
        });

    }
}
