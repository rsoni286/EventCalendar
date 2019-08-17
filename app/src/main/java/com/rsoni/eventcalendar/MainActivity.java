package com.rsoni.eventcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rsoni.Calendar.EventCalendar;
import com.rsoni.Calendar.model.Event;
import com.rsoni.Calendar.utils.CalendarUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EventCalendar calendar = findViewById(R.id.calendar);
        calendar.setHeaderColor(getResources().getColor(R.color.colorAccent));
        List<Event> events = new ArrayList<>();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        events.add(new Event(calendar1, getResources().getColor(R.color.colorPrimary)));
        calendar1.set(Calendar.DAY_OF_MONTH, 22);
        events.add(new Event(calendar1, getResources().getColor(R.color.colorDefault)));
        calendar.setEvents(events);


    }
}
