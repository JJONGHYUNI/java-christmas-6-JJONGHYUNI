package christmas.service;

import christmas.model.day.Day;
import christmas.model.day.constant.Calendar;
import christmas.model.event.*;

public class EventService {
    public Event createEvent(Day day) {
        Calendar calendar = day.getCalendar();
        if (isChristmas(calendar)) return new ChristmasEvent();
        if (isWeekDay(calendar)) return new WeekDayEvent();
        if (isWeekend(calendar)) return new WeekendEvent();
        return new SundayEvent();
    }

    private boolean isChristmas(Calendar calendar) {
        return calendar == Calendar.CHRISTMAS;
    }

    private boolean isWeekDay(Calendar calendar) {
        return calendar == Calendar.WEEKDAY;
    }

    private boolean isWeekend(Calendar calendar) {
        return calendar == Calendar.WEEKEND;
    }

    private boolean isSunday(Calendar calendar) {
        return calendar == Calendar.SUNDAY;
    }
}
