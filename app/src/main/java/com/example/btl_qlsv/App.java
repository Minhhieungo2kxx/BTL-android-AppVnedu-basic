package com.example.btl_qlsv;

import android.app.Application;

import com.example.btl_qlsv.models.Teacher;

public class App  extends Application {

    private Teacher gv = null;

    public Teacher getTeacher() {
        return gv;
    }

    public void setTeacher(Teacher gv) {
        this.gv = gv;
    }
}
