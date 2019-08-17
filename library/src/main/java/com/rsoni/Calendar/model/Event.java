package com.rsoni.Calendar.model;

import com.rsoni.Calendar.utils.CalendarUtils;

import java.util.Calendar;

public class Event {
    private int color;

    private Calendar calendar;

    public Event() {
    }

    public Event(Calendar calendar, int color) {
        this.color = color;
        this.calendar = calendar;
        CalendarUtils.setMidnight(calendar);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
        CalendarUtils.setMidnight(this.calendar);
    }
}
