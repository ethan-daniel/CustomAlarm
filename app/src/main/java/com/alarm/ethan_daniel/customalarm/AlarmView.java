package com.alarm.ethan_daniel.customalarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
        mAlarmTime = findViewById(R.id.alarm_time);
        mAlarmDay = findViewById(R.id.alarm_day);
        mAlarmAMorPM = findViewById(R.id.alarm_am_or_pm);
        mAlarmToggle = findViewById(R.id.alarm_toggle);
        setAlarm(calendar, true);
    }
    public void setAlarm(Calendar calendar, boolean onOrOff) {
        mTime = calendar;
        mAlarmToggle.setChecked(onOrOff);

    }

}
