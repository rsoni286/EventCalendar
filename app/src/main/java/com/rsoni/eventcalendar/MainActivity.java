package com.rsoni.eventcalendar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.rsoni.Calendar.EventCalendar;
import com.rsoni.Calendar.listener.OnDateClickedListener;
import com.rsoni.Calendar.model.Event;
import com.rsoni.Calendar.model.EventDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getColor(android.R.color.white));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        //Customize EventCalendar
        EventCalendar eventCalendar = findViewById(R.id.calendar);
        eventCalendar.setHeaderBackground(ContextCompat.getDrawable(this, R.drawable.custom_drawable));
        eventCalendar.setBackground(ContextCompat.getDrawable(this, R.drawable.accent_border));

        //add events
        List<Event> events = new ArrayList<>();

        //set default shape for event days to rounded square
        eventCalendar.setDefaultEventDayShape(EventCalendar.EventShape.ROUNDED_SQUARE);

        //set default shape for no event days to rounded square
        eventCalendar.setNoEventDayShape(EventCalendar.EventShape.ROUNDED_SQUARE);
        eventCalendar.setNoEventDayBackgroundColor(getResources().getColor(R.color.colorAccentLite));
        eventCalendar.setNoEventDayTextColor(getResources().getColor(R.color.colorAccent));
        //eventCalendar.setNoEventDayBackground(ContextCompat.getDrawable(this, R.drawable.accent_border));

        //calendar for creating event
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        //event with circle shape
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));//calendar starts from 0 for january
            events.add(new Event(eventDate, getResources().getColor(R.color.colorPrimary), EventCalendar.EventShape.CIRCLE));
        }

        calendar.add(Calendar.DAY_OF_MONTH, 8);

        //event with custom drawable
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate2 = EventDate.fromCalendar(calendar);
            events.add(new Event(eventDate2, ContextCompat.getDrawable(this, R.drawable.custom_drawable)));
        }

        //event with custom drawable and text color
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate2 = EventDate.fromCalendar(calendar);
            events.add(new Event(eventDate2, ContextCompat.getDrawable(this, R.drawable.custom_drawable), getResources().getColor(R.color.colorAccent)));
        }

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        //event with only background color and default shape
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate2 = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
            events.add(new Event(eventDate2, getResources().getColor(R.color.colorAccent)));
        }

        //Set events to calendar
        eventCalendar.setEvents(events);


        //onDateClickListener
        eventCalendar.setOnDateClickedListener(new OnDateClickedListener() {
            @Override
            public void onDateClicked(Event event) {
                Toast.makeText(MainActivity.this, event.getEventDate().getYear() + "-" + event.getEventDate().getMonth() + "-" + event.getEventDate().getDay(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
