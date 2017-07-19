package com.alarm.ethan_daniel.customalarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;
public class AlarmView extends RelativeLayout {
    private TextView mAlarmTime;
    private TextView mAlarmDay;
    private TextView mAlarmAMorPM;
    private Switch mAlarmToggle;
    private Calendar mTime;

    public AlarmView(Context context, Calendar calendar) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_alarm, this, true);
        mAlarmTime = (TextView) findViewById(R.id.alarm_time);
        mAlarmDay = (TextView) findViewById(R.id.alarm_day);
        mAlarmAMorPM = (TextView) findViewById(R.id.alarm_am_or_pm);
        mAlarmToggle = (Switch) findViewById(R.id.alarm_toggle);
        setAlarmTime(calendar);
    }
    public void setAlarmTime(Calendar calendar) {
        mTime = calendar;
        mAlarmTime.setText(R.string.alarm_time_pass % calendar.HOUR);
    }
}
