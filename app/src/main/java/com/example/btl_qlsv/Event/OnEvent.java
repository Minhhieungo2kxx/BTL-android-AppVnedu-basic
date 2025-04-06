package com.example.btl_qlsv.Event;


import com.example.btl_qlsv.models.Event;

public interface OnEvent {


    void onEditEvent(Event event, int position);

    void onEventDelete(Event event,int position);
}
