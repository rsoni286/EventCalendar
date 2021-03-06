package com.rsoni.Calendar.utils;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.rsoni.Calendar.EventCalendar;
import com.rsoni.Calendar.R;

public class GraphicUtils {

    public static void setDayColor(TextView tv, int color, int textColor, @NonNull EventCalendar.EventShape eventShape) {
        int drawable;
        if (eventShape == EventCalendar.EventShape.CIRCLE) {
            drawable = R.drawable.background_circle;
        } else if (eventShape == EventCalendar.EventShape.SQUARE) {
            drawable = R.drawable.background_square;
        } else {
            drawable = R.drawable.background_square_rounded;
        }

        setDayColors(tv, textColor, Typeface.NORMAL, drawable);
        MyDrawableCompat.setColorFilter(tv.getBackground(), color);

    }

    private static void setDayColors(TextView textView, int textColor, int typeface, int background) {
        if (textView == null) {
            return;
        }

        textView.setTypeface(null, typeface);
        textView.setTextColor(textColor);
        textView.setBackgroundResource(background);
    }

    public static void setDayDrawable(TextView textView, Drawable drawable, int textColor) {
        if (textView == null) {
            return;
        }

        textView.setTypeface(null, Typeface.NORMAL);
        textView.setTextColor(textColor);
        textView.setBackground(drawable);
    }

}



