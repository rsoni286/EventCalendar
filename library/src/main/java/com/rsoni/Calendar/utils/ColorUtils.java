package com.rsoni.Calendar.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.rsoni.Calendar.R;

public class ColorUtils {

    public static void setDayColor(Context context, TextView tv, int color) {
        setDayColors(tv, context.getResources().getColor(android.R.color.white), Typeface.NORMAL,
                R.drawable.background_circle);

        tv.getBackground().setColorFilter(color,
                android.graphics.PorterDuff.Mode.MULTIPLY);

    }

    private static void setDayColors(TextView textView, int textColor, int typeface, int background) {
        if (textView == null) {
            return;
        }

        textView.setTypeface(null, typeface);
        textView.setTextColor(textColor);
        textView.setBackgroundResource(background);
    }

}
