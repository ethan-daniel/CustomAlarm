package com.alarm.ethan_daniel.customalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.DocumentsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

class MainActivity extends AppCompatActivity {

    public static boolean fabVisible;
    private FloatingActionButton mFabAlarm;
    private RecyclerView mAlarmsList;
    private RecyclerView.Adapter mAlarmsAdapter;
    private ArrayList<Alarm> savedAlarms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mFabAlarm = findViewById(R.id.fab_add);
        mAlarmsList = findViewById(R.id.alarms_list);
        mAlarmsList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mAlarmsList.setLayoutManager(llm);

        mAlarmsAdapter = new AlarmListAdapter(savedAlarms);
        mAlarmsList.setAdapter(mAlarmsAdapter);
        savedAlarms.add(new Alarm(Calendar.getInstance(), true));
        savedAlarms.add(new Alarm(Calendar.getInstance(), true));
        savedAlarms.add(new Alarm(Calendar.getInstance(), true));
        mAlarmsAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addAlarm() {
        AlarmView alarmView = new AlarmView(this, Calendar.getInstance());
        mAlarmsList.addView(alarmView);
    }
}
