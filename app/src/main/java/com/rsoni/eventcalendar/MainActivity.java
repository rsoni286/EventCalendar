package com.rsoni.eventcalendar;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rsoni.Calendar.EventCalendar;
import com.rsoni.Calendar.Listener.onDateClickedListener;
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

        //EventCalendar
        EventCalendar eventCalendar = findViewById(R.id.calendar);

        //create events list
        List<Event> events = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        EventDate eventDate = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));//calendar starts from 0 for january
        events.add(new Event(eventDate, getResources().getColor(R.color.colorPrimary)));

        calendar.set(Calendar.DAY_OF_MONTH, 22);
        EventDate eventDate1 = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        events.add(new Event(eventDate1, getResources().getColor(R.color.colorDefault)));


        for (int i = 0; i < 10; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate2 = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
            events.add(new Event(eventDate2, getResources().getColor(R.color.colorAccent), getResources().getColor(android.R.color.holo_blue_bright)));
        }

        eventCalendar.setDayEventShape(EventCalendar.EventShape.ROUNDED_SQUARE);
        //Set events to calendar
        eventCalendar.setEvents(events);


        //onDateClickListener
        eventCalendar.setOnDateClickedListener(new onDateClickedListener() {
            @Override
            public void onDateClicked(Event event) {
                Toast.makeText(MainActivity.this, event.getEventDate().getYear() + "-" + event.getEventDate().getMonth() + "-" + event.getEventDate().getDay(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
