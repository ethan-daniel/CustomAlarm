package com.alarm.ethan_daniel.customalarm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AlarmListAdapter extends RecyclerView.Adapter<AlarmListAdapter.ViewHolder> {

    private ArrayList<Alarm> mAlarmsList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView myAlarmTime;
        public TextView myAMorPM;
        public TextView myAlarmDay;
        public Switch mySwitch;

        public ViewHolder(View v) {
            super(v);
            //Initialize all views in AlarmView
            myAlarmTime = (TextView) v.findViewById(R.id.alarm_time);
            myAMorPM = (TextView) v.findViewById(R.id.alarm_am_or_pm);
            myAlarmDay = (TextView) v.findViewById(R.id.alarm_day);
            mySwitch = (Switch) v.findViewById(R.id.alarm_toggle);
        }
    }

    public AlarmListAdapter(ArrayList<Alarm> data) {
        mAlarmsList = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View alarmView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_alarm, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(alarmView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Alarm alarm = mAlarmsList.get(position);
        //Set alarm time
        holder.myAlarmTime.setText(alarm.getAlarmTime().HOUR + ":" +alarm.getAlarmTime().MINUTE);
        //Check for AM or PM alarm
        if(alarm.getAlarmTime().HOUR < 12)
            holder.myAMorPM.setText(R.string.am);
        else
            holder.myAMorPM.setText(R.string.pm);
        //Check which day the alarm occurs
        if(alarm.getAlarmTime().compareTo(Calendar.getInstance()) == 1 )
            holder.myAlarmDay.setText(R.string.tomorrow);
        else
            holder.myAlarmDay.setText(R.string.today);
        //Set alarm to be on
        holder.mySwitch.setChecked(true);

    }

    @Override
    public int getItemCount() {
        if(mAlarmsList != null) {
            return mAlarmsList.size();
        }
        return 0;
    }
}
