package com.rsoni.Calendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.rsoni.Calendar.Listener.onDateClickedListener;
import com.rsoni.Calendar.R;
import com.rsoni.Calendar.model.Event;
import com.rsoni.Calendar.utils.CalendarUtils;
import com.rsoni.Calendar.utils.GraphicUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.vh> {
    private ArrayList<Date> dates;
    private HashMap<String, Event> eventMap;
    private int currentMonth;
    private onDateClickedListener listener;
    private final Context context;
    private final Calendar checkCalendar;
    private final int colorTrans, colorBlack, colorWhite;

    public CalendarAdapter(Context context, ArrayList<Date> dates, int currentMonth, onDateClickedListener listener) {
        this.dates = dates;
        this.currentMonth = currentMonth;
        this.context = context;
        this.eventMap = new HashMap<>();
        this.listener = listener;
        checkCalendar = Calendar.getInstance();
        colorTrans = ContextCompat.getColor(context, android.R.color.transparent);
        colorBlack = ContextCompat.getColor(context, android.R.color.black);
        colorWhite = ContextCompat.getColor(context, android.R.color.white);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public CalendarAdapter.vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.day_layout, viewGroup, false);
        return new vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarAdapter.vh vh, int i) {
        checkCalendar.setTime(dates.get(i));

        vh.tv.setText(String.valueOf(checkCalendar.get(Calendar.DAY_OF_MONTH)));
        vh.tv.setAlpha(isCurrentMonth(checkCalendar) ? 1.0f : 0.12f);

        Event event = eventMap.get(CalendarUtils.getCalendarKey(context, checkCalendar));
        handleEvent(event, vh);
    }

    private void handleEvent(Event event, vh vh) {
        //if no event, just set normal text color
        if (event == null) {
            GraphicUtils.setDayColor(vh.tv, colorTrans, colorBlack);
            return;
        }

        if (event.getColor() != null) {
            GraphicUtils.setDayColor(vh.tv, event.getColor(), event.getTextColor() == null ? colorWhite : event.getTextColor());
        } else if (event.getDrawable() != null) {
            GraphicUtils.setDayDrawable(vh.tv, event.getDrawable(), event.getTextColor() == null ? colorWhite : event.getTextColor());
        } else {
            vh.tv.setTextColor(event.getTextColor() == null ? colorBlack : event.getTextColor());
        }
    }

    private boolean isCurrentMonth(Calendar calendar) {
        return calendar.get(Calendar.MONTH) == currentMonth;
    }


    @Override
    public int getItemCount() {
        return dates.size();
    }


    public void updateDate(ArrayList<Date> dates) {
        this.dates = dates;
        notifyDataSetChanged();
    }

    public void updateMonth(int currentMonth) {
        this.currentMonth = currentMonth;
        notifyDataSetChanged();
    }

    public void updateEvent(HashMap<String, Event> eventMap) {
        this.eventMap = eventMap;
        notifyDataSetChanged();
    }

    public void setListener(onDateClickedListener listener) {
        this.listener = listener;
        notifyDataSetChanged();
    }

    class vh extends RecyclerView.ViewHolder {
        View view;
        TextView tv;

        vh(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            tv = view.findViewById(R.id.tv_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position == RecyclerView.NO_POSITION) return;

                    notifyListener(position);
                }
            });
        }
    }

    private void notifyListener(int position) {
        Date date = dates.get(position);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Event event = eventMap.get(CalendarUtils.getCalendarKey(context, calendar));

        if (listener != null) {
            if (event != null) {
                listener.onDateClicked(event);
            } else {
                listener.onDateClicked(new Event(calendar, 0));
            }
        }
    }


}
