package com.rsoni.Calendar.utils;

import android.content.Context;

import com.rsoni.Calendar.R;

import java.util.Calendar;

public class CalendarUtils {


    public static void setMidnight(Calendar calendar) {
        if (calendar != null) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }
    }

    public static String getMonthAndYearDate(Context context, Calendar calendar) {
        return String.format("%s  %s",
                context.getResources().getStringArray(R.array.material_calendar_months_array)[calendar.get(Calendar.MONTH)],
                calendar.get(Calendar.YEAR));
    }



}
