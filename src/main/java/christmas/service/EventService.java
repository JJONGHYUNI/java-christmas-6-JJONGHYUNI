package christmas.service;

import christmas.model.date.Date;
import christmas.model.date.constant.Calendar;
import christmas.model.event.*;

public class EventService {
    public Event createEvent(Date date) {
        Calendar calendar = date.getCalendar();
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
}
