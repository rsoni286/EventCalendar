package com.rsoni.Calendar.utils;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.rsoni.Calendar.R;

public class ColorUtils {

    public static void setDayColor(Context context, TextView tv, int color) {
        setDayColors(tv, ContextCompat.getColor(context, android.R.color.white), Typeface.NORMAL,
                R.drawable.background_circle);
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

}



