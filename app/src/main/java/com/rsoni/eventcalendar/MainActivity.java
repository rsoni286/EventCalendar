package com.rsoni.eventcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

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
        EventCalendar calendar = findViewById(R.id.calendar);
        calendar.setHeaderColor(getResources().getColor(R.color.colorAccent));
        calendar.setSaturdayLabelColor(getResources().getColor(R.color.colorAccent));

        //create events list
        List<Event> events = new ArrayList<>();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        events.add(new Event(calendar1, getResources().getColor(R.color.colorPrimary)));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 22);
        events.add(new Event(calendar2, getResources().getColor(R.color.colorDefault)));

        //Set events to calendar
        calendar.setEvents(events);

        //onDateClickListener
        calendar.setOnDateClickedListener(new onDateClickedListener() {
            @Override
            public void onDateClicked(Event event) {
                Toast.makeText(MainActivity.this, DateFormat.format("yyyy-MM-dd", event.getCalendar().getTime()), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
