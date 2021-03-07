package com.rsoni.Calendar;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rsoni.Calendar.adapter.CalendarAdapter;
import com.rsoni.Calendar.listener.OnDateClickedListener;
import com.rsoni.Calendar.model.Event;
import com.rsoni.Calendar.model.EventDate;
import com.rsoni.Calendar.utils.CalendarUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static com.rsoni.Calendar.utils.CalendarUtils.getCalendarKey;

public class EventCalendar extends LinearLayout {
    public enum EventShape {
        CIRCLE, SQUARE, ROUNDED_SQUARE
    }

    private LinearLayout header;
    private TextView sTv, monthTv;
    private int CURRENT_MONTH = 0;
    private int TEMP_MONTH;
    private ArrayList<EventDate> dates;
    private CalendarAdapter calendarAdapter;
    private OnDateClickedListener listener = null;

    public EventCalendar(Context context) {
        super(context);
        init(context);
    }

    public EventCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EventCalendar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EventCalendar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_calendar, this, true);
        initElements(view);
    }

    private void initElements(View view) {
        header = view.findViewById(R.id.header);
        sTv = view.findViewById(R.id.tv_sat);
        monthTv = view.findViewById(R.id.tvMonth);
        ImageButton prevBtn = view.findViewById(R.id.btnPrev);
        ImageButton nextBtn = view.findViewById(R.id.btnNext);
        RecyclerView calendar = view.findViewById(R.id.recycleCalendar);
        dates = loadDates(CURRENT_MONTH);

        calendarAdapter = new CalendarAdapter(getContext(), dates, TEMP_MONTH, listener);
        calendar.setHasFixedSize(true);
        calendar.setLayoutManager(new GridLayoutManager(getContext(), 7));
        calendar.setAdapter(calendarAdapter);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_MONTH++;
                dates = loadDates(CURRENT_MONTH);
                calendarAdapter.updateDate(dates);
                calendarAdapter.updateMonth(TEMP_MONTH);
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_MONTH--;
                dates = loadDates(CURRENT_MONTH);
                calendarAdapter.updateDate(dates);
                calendarAdapter.updateMonth(TEMP_MONTH);
            }
        });

    }

    private ArrayList<EventDate> loadDates(int current_month) {
        ArrayList<EventDate> days = new ArrayList<>();

        // Get Calendar object instance
        Calendar calendar = Calendar.getInstance();
        CalendarUtils.setMidnight(calendar);

        // Add months to Calendar (a number of months depends on ViewPager position)
        calendar.add(Calendar.MONTH, current_month);
        TEMP_MONTH = calendar.get(Calendar.MONTH);
        monthTv.setText(CalendarUtils.getMonthAndYearDate(getContext(), calendar));
        // Set day of month as 1 ()
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Get a number of the first day of the week
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Count when month is beginning
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        int monthBeginningCell = (dayOfWeek < firstDayOfWeek ? 7 : 0) + dayOfWeek - firstDayOfWeek;

        // Subtract a number of beginning days, it will let to load a part of a previous month
        calendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell);

        /*
        Get all days of one page (42 is a number of all possible cells in one page
        (a part of previous month, current month and a part of next month))
         */

        while (days.size() < 42) {
            days.add(EventDate.fromCalendar(calendar));
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }

        return days;
    }

    public void setHeaderColor(int color) {
        header.setBackgroundColor(color);
    }

    public void setSaturdayLabelColor(int color) {
        sTv.setTextColor(color);
    }

    public void setEvents(List<Event> events) {
        calendarAdapter.updateEvent(createEventMap(events));
    }

    private HashMap<String, Event> createEventMap(List<Event> events) {
        HashMap<String, Event> eventMap = new HashMap<>();
        for (Event event : events) {
            eventMap.put(getCalendarKey(getContext(), event.getEventDate()), event);
        }
        return eventMap;
    }

    public void setOnDateClickedListener(OnDateClickedListener listener) {
        this.listener = listener;
        calendarAdapter.setListener(listener);
    }

    public void setDefaultDayEventShape(EventShape eventShape) {
        calendarAdapter.setDefaultEventShape(eventShape);
    }


}
