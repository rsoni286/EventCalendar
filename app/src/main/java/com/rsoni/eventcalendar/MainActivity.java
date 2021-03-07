package com.rsoni.eventcalendar;

import android.os.Bundle;
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

        //Customize EventCalendar
        EventCalendar eventCalendar = findViewById(R.id.calendar);

        /*
        //set month header background
        eventCalendar.setHeaderBackgroundColor(getResources().getColor(R.color.colorAccent));
        //set saturday label color
        eventCalendar.setSaturdayLabelColor(getResources().getColor(R.color.colorAccent));
        //set day labels(sunday to saturday) background
        eventCalendar.setDayLabelsBackgroundColor(getResources().getColor(R.color.colorAccent));
        //set calendar dates background
        eventCalendar.setDatesGridBackgroundColor(getResources().getColor(R.color.colorAccent));
        //set calendar background(both day labels and dates)
        eventCalendar.setCalendarBackground(ContextCompat.getDrawable(this, R.drawable.custom_drawable));
        //set prev/next btn background
        eventCalendar.setPrevBtnBackground(ContextCompat.getDrawable(this, R.drawable.custom_drawable));
        eventCalendar.setNextBtnBackground(ContextCompat.getDrawable(this, R.drawable.custom_drawable));
        */

        //add events
        List<Event> events = new ArrayList<>();

        //set default shape to rounded square
        eventCalendar.setDefaultDayEventShape(EventCalendar.EventShape.ROUNDED_SQUARE);

        //calendar for creating event
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        //event with circle shape
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));//calendar starts from 0 for january
            events.add(new Event(eventDate, getResources().getColor(R.color.colorPrimary), EventCalendar.EventShape.CIRCLE));
        }

        //event with square shape and text color
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));//calendar starts from 0 for january
            events.add(new Event(eventDate, getResources().getColor(R.color.colorDefault), getResources().getColor(android.R.color.holo_blue_bright), EventCalendar.EventShape.SQUARE));
        }

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
