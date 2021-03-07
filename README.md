# EventCalendar
A simple android calendar library that marks various dates with events on calendar.

### Customizations supported:

- Change header, labels, calendar background to custom drawable or color.
- Set events which can be highlighted with colors of 3 different shapes (circle,sqaure or rounded square) or with your own custom drawable.
- Set your own drawable and background for next and prev buttons. 
- OnCLick Listener for each date that returns Event for that day.

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
	        implementation 'com.github.rsoni286:EventCalendar:1.1.7'
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

        //Customize EventCalendar
        EventCalendar eventCalendar = findViewById(R.id.calendar);
        eventCalendar.setHeaderBackground(ContextCompat.getDrawable(this, R.drawable.custom_drawable));
        eventCalendar.setBackground(ContextCompat.getDrawable(this, R.drawable.accent_border));

        //add events
        List<Event> events = new ArrayList<>();

        //set default shape for event days to rounded square
        eventCalendar.setDefaultEventDayShape(EventCalendar.EventShape.ROUNDED_SQUARE);

        //set default shape for no event days to rounded square
        eventCalendar.setNoEventDayShape(EventCalendar.EventShape.ROUNDED_SQUARE);
        eventCalendar.setNoEventDayBackgroundColor(getResources().getColor(R.color.colorAccentLite));
        eventCalendar.setNoEventDayTextColor(getResources().getColor(R.color.colorAccent));
        //eventCalendar.setNoEventDayBackground(ContextCompat.getDrawable(this, R.drawable.accent_border));

        //calendar for creating event
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        //event with circle shape
        for (int i = 0; i < 5; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            EventDate eventDate = new EventDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));//calendar starts from 0 for january
            events.add(new Event(eventDate, getResources().getColor(R.color.colorPrimary), EventCalendar.EventShape.CIRCLE));
        }

        calendar.add(Calendar.DAY_OF_MONTH, 8);

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


        //OnDateClickListener
        eventCalendar.setOnDateClickedListener(new OnDateClickedListener() {
            @Override
            public void onDateClicked(Event event) {
                Toast.makeText(MainActivity.this, event.getEventDate().getYear() + "-" + event.getEventDate().getMonth() + "-" + event.getEventDate().getDay(), Toast.LENGTH_SHORT).show();
            }
        });
```

## Samples

1. With 
```
	eventCalendar.setNoEventDayShape(EventCalendar.EventShape.ROUNDED_SQUARE);
        eventCalendar.setNoEventDayBackgroundColor(getResources().getColor(R.color.colorAccentLite));
        eventCalendar.setNoEventDayTextColor(getResources().getColor(R.color.colorAccent));
```
![Screenshot_2021-03-07-13-42-40-84_3c61661eb8ed31f8834d96ff0fcb3e10](https://user-images.githubusercontent.com/47516112/110233380-b754e100-7f4b-11eb-810e-076ac2f79c2c.jpg)

2. With 
```
	eventCalendar.setNoEventDayShape(EventCalendar.EventShape.ROUNDED_SQUARE);
        eventCalendar.setNoEventDayBackgroundColor(getResources().getColor(R.color.colorAccentLite));
```
![Screenshot_2021-03-07-13-41-56-37_3c61661eb8ed31f8834d96ff0fcb3e10](https://user-images.githubusercontent.com/47516112/110233394-e1a69e80-7f4b-11eb-926a-c9cc4eaeccb0.jpg)

3. With
```
	eventCalendar.setNoEventDayBackground(ContextCompat.getDrawable(this, R.drawable.accent_border));
```
![Screenshot_2021-03-07-13-41-33-23_3c61661eb8ed31f8834d96ff0fcb3e10](https://user-images.githubusercontent.com/47516112/110233410-fe42d680-7f4b-11eb-8535-dee668265c8b.jpg)



