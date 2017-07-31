package com.alarm.ethan_daniel.customalarm;

import android.app.AlarmManager;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Alarm {
    protected boolean mToggleAlarm;
    protected int mAlarmDay;
    protected Calendar mAlarmTime;

    public Alarm(Calendar calendar, boolean onOrOff) {
        mAlarmTime = calendar;
        mAlarmDay = calendar.HOUR;
        mToggleAlarm = onOrOff;
    }

    public Calendar getAlarmTime() {
        return mAlarmTime;
    }

    public void setAlarmTime(Calendar calendar) {
        mAlarmTime = calendar;
    }

    public boolean getToggleStatus() {
        return mToggleAlarm;
    }

    public void setToggleStatus(boolean onOrOff) {
        mToggleAlarm = onOrOff;
    }

    @Override
    public String toString() {
        return mAlarmTime.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Alarm && ((Alarm) obj).getAlarmTime() == mAlarmTime) {
            return true;
        }
        return false;
    }

}
