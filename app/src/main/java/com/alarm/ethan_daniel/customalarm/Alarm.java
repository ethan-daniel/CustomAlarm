package com.alarm.ethan_daniel.customalarm;

import android.app.AlarmManager;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Alarm {
    private boolean mToggleAlarm;
    private int mAlarmDay;
    private Calendar mAlarmTime;

    private Alarm(Calendar calendar, boolean onOrOff) {
        mAlarmTime = calendar;
        mAlarmDay = calendar.HOUR;
        mToggleAlarm = onOrOff;
    }

    Calendar getAlarmTime() {
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
        return (obj instanceof Alarm && ((Alarm) obj).getAlarmTime() == mAlarmTime);
    }

}
