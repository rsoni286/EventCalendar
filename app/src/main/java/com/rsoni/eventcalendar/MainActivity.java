package com.rsoni.eventcalendar;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.rsoni.Calendar.EventCalendar;
import com.rsoni.Calendar.Listener.onDateClickedListener;
import com.rsoni.Calendar.model.Event;

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
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        events.add(new Event(calendar, getResources().getColor(R.color.colorPrimary)));

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 22);
        events.add(new Event(calendar1, getResources().getColor(R.color.colorDefault)));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 27);
        events.add(new Event(calendar2, ContextCompat.getDrawable(this, R.drawable.ic_launcher_background)));

        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.DAY_OF_MONTH, 7);
        events.add(new Event(calendar3, ContextCompat.getDrawable(this, R.drawable.ic_launcher_background), getResources().getColor(android.R.color.holo_blue_bright)));

        //Set events to calendar
        eventCalendar.setEvents(events);

        //onDateClickListener
        eventCalendar.setOnDateClickedListener(new onDateClickedListener() {
            @Override
            public void onDateClicked(Event event) {
                Toast.makeText(MainActivity.this, DateFormat.format("yyyy-MM-dd", event.getCalendar().getTime()), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
