package com.rsoni.Calendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.rsoni.Calendar.Listener.onDateClickedListener;
import com.rsoni.Calendar.R;
import com.rsoni.Calendar.model.Event;
import com.rsoni.Calendar.utils.ColorUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.vh> {
    private ArrayList<Date> dates;
    private List<Event> events;
    private Context context;
    private int currentMonth;
    private onDateClickedListener listener;

    public CalendarAdapter(Context context, ArrayList<Date> dates, int currentMonth, List<Event> events, onDateClickedListener listener) {
        this.dates = dates;
        this.currentMonth = currentMonth;
        this.context = context;
        this.events = events;
        this.listener = listener;
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
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(dates.get(i));

        vh.tv.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        ColorUtils.setDayColor(context, vh.tv,getResources().getColor(android.R.color.transparent));
        Event temp = null;
        for (Event event : events) {
            if (event.getCalendar().getTimeInMillis() == calendar.getTimeInMillis()) {
                ColorUtils.setDayColor(context, vh.tv, event.getColor());
                temp = event;
                break;
            }
        }

        if (!isCurrentMonth(calendar)) vh.tv.setAlpha(0.12f);
        else vh.tv.setAlpha(1.0f);

        final Event finalTemp = temp;
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (finalTemp != null) {
                        listener.onDateClicked(finalTemp);
                    } else {
                        listener.onDateClicked(new Event(calendar, 0));
                    }
                }
            }
        });
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

    public void updateEvent(List<Event> events) {
        this.events = events;
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
        }
    }


}
