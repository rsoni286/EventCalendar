package com.rsoni.Calendar.model;

import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.rsoni.Calendar.EventCalendar;

public class Event {
    @NonNull
    private EventDate eventDate;
    @ColorInt
    private Integer color;
    @ColorInt
    private Integer textColor;
    private Drawable drawable;

    private EventCalendar.EventShape eventShape;

    public Event(@NonNull EventDate eventDate, Integer color) {
        this.color = color;
        this.eventDate = eventDate;
    }

    public Event(@NonNull EventDate eventDate, Integer color, EventCalendar.EventShape eventShape) {
        this.color = color;
        this.eventDate = eventDate;
        this.eventShape = eventShape;
    }

    public Event(@NonNull EventDate eventDate, Drawable drawable) {
        this.eventDate = eventDate;
        this.drawable = drawable;
    }

    public Event(@NonNull EventDate eventDate, Integer color, Integer textColor) {
        this.color = color;
        this.eventDate = eventDate;
        this.textColor = textColor;
    }

    public Event(@NonNull EventDate eventDate, Integer color, Integer textColor, EventCalendar.EventShape eventShape) {
        this.color = color;
        this.eventDate = eventDate;
        this.textColor = textColor;
        this.eventShape = eventShape;
    }

    public Event(@NonNull EventDate eventDate, Drawable drawable, Integer textColor) {
        this.eventDate = eventDate;
        this.drawable = drawable;
        this.textColor = textColor;
    }

    public Integer getTextColor() {
        return textColor;
    }

    public void setTextColor(Integer textColor) {
        this.textColor = textColor;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    @NonNull
    public EventDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(@NonNull EventDate eventDate) {
        this.eventDate = eventDate;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public EventCalendar.EventShape getEventShape() {
        return eventShape;
    }

    public void setEventShape(EventCalendar.EventShape eventShape) {
        this.eventShape = eventShape;
    }
}
