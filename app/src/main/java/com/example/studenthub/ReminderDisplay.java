package com.example.studenthub;

public class ReminderDisplay {
    public String moduleTitle, assignMsg, date, time;

    public ReminderDisplay(){}

    public ReminderDisplay(String mTitle, String aMsg, String date, String time){
        this.moduleTitle = mTitle;
        this.assignMsg = aMsg;
        this.date = date;
        this.time = time;
    }
}
