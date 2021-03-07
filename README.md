# EventCalendar
A simple android calendar library that marks various dates with events on calendar.

Easy to use and customize

- Can change header color

- Easily set custom events

- OnCLick Listener for each date that returns Event for that day

## Getting Started

Step 1.Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```
	dependencies {
	        implementation 'com.github.rsoni286:EventCalendar:1.1.6'
	}
```
## Add to xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.rsoni.Calendar.EventCalendar
        android:id="@+id/calendar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="12dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

## Java code

```
    //EventCalendar

        EventCalendar calendar = findViewById(R.id.calendar);
        
	//set month header background
        eventCalendar.setHeaderBackgroundColor(getResources().getColor(R.color.colorAccent));
        //set saturday label color
        eventCalendar.setSaturdayLabelColor(getResources().getColor(R.color.colorAccent));
        //set day labels(sunday to saturday) background
        eventCalendar.setDayLabelsBackgroundColor(getResources().getColor(R.color.colorAccent));
        //set calendar dates background
        eventCalendar.setDatesGridBackgroundColor(getResources().getColor(R.color.colorAccent));
        //set calendar background(both day labels and dates)
        eventCalendar.setCalendarBackground(ContextCompat.getDrawable(this, R.drawable.custom_drawable));
        //set prev/next btn background
        eventCalendar.setPrevBtnBackground(ContextCompat.getDrawable(this, R.drawable.custom_drawable));
        eventCalendar.setNextBtnBackground(ContextCompat.getDrawable(this, R.drawable.custom_drawable));

        //add events
        List<Event> events = new ArrayList<>();

        //set default shape to rounded square
        eventCalendar.setDefaultDayEventShape(EventCalendar.EventShape.ROUNDED_SQUARE);

        //calendar for creating event
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        //event with circle shape
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));//calendar starts from 0 for january
            events.add(new Event(eventDate, getResources().getColor(R.color.colorPrimary), EventCalendar.EventShape.CIRCLE));
        }

        //event with square shape and text color
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));//calendar starts from 0 for january
            events.add(new Event(eventDate, getResources().getColor(R.color.colorDefault), getResources().getColor(android.R.color.holo_blue_bright), EventCalendar.EventShape.SQUARE));
        }

        //event with custom drawable
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate2 = EventDate.fromCalendar(calendar);
            events.add(new Event(eventDate2, ContextCompat.getDrawable(this, R.drawable.custom_drawable)));
        }

        //event with custom drawable and text color
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate2 = EventDate.fromCalendar(calendar);
            events.add(new Event(eventDate2, ContextCompat.getDrawable(this, R.drawable.custom_drawable), getResources().getColor(R.color.colorAccent)));
        }

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        //event with only background color and default shape
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate2 = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
            events.add(new Event(eventDate2, getResources().getColor(R.color.colorAccent)));
        }

        //Set events to calendar
        eventCalendar.setEvents(events);


        //onDateClickListener
        eventCalendar.setOnDateClickedListener(new OnDateClickedListener() {
            @Override
            public void onDateClicked(Event event) {
                Toast.makeText(MainActivity.this, event.getEventDate().getYear() + "-" + event.getEventDate().getMonth() + "-" + event.getEventDate().getDay(), Toast.LENGTH_SHORT).show();
            }
        });
```

