package com.rsoni.Calendar.model;

import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import java.util.Calendar;

public class Event {
    @NonNull
    private Calendar calendar;

    @ColorInt
    private Integer color;

    @ColorInt
    private Integer textColor;

    private Drawable drawable;

    public Event(@NonNull Calendar calendar, Integer color) {
        this.color = color;
        this.calendar = calendar;
    }

    public Event(@NonNull Calendar calendar, Drawable drawable) {
        this.calendar = calendar;
        this.drawable = drawable;
    }

    public Event(@NonNull Calendar calendar, Integer color, Integer textColor) {
        this.color = color;
        this.calendar = calendar;
        this.textColor = textColor;
    }

    public Event(@NonNull Calendar calendar, Drawable drawable, Integer textColor) {
        this.calendar = calendar;
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
    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(@NonNull Calendar calendar) {
        this.calendar = calendar;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
