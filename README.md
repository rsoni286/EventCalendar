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
	        implementation 'com.github.rsoni286:EventCalendar:1.1.1'
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
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

## Java code

```
    //EventCalendar

        EventCalendar calendar = findViewById(R.id.calendar);
        calendar.setHeaderColor(getResources().getColor(R.color.colorAccent));
        calendar.setSaturdayLabelColor(getResources().getColor(R.color.colorAccent));

        //create events list
        List<Event> events = new ArrayList<>();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        events.add(new Event(calendar1, getResources().getColor(R.color.colorPrimary)));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 22);
        events.add(new Event(calendar2, getResources().getColor(R.color.colorDefault)));

        //Set events to calendar
        calendar.setEvents(events);

        //onDateClickListener
        calendar.setOnDateClickedListener(new onDateClickedListener() {
            @Override
            public void onDateClicked(Event event) {
                Toast.makeText(MainActivity.this, DateFormat.format("yyyy-MM-dd", event.getCalendar().getTime()), Toast.LENGTH_SHORT).show();
            }
        });
```

