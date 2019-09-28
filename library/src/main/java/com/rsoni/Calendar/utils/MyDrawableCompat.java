package com.rsoni.Calendar.utils;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.annotation.NonNull;

public class MyDrawableCompat {
    public static void setColorFilter(@NonNull Drawable drawable, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable.setColorFilter(new BlendModeColorFilter(color, BlendMode.MULTIPLY));
        } else {
            drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        }
    }
}