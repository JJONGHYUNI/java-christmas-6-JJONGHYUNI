package christmas.model;

import christmas.model.constant.DateConstant;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Day {
    private final int day;
    private final DateConstant dateConstant;

    public Day(int day) {
        this.day = day;
        if(isChristmas(day)) {
            this.dateConstant = DateConstant.CHRISTMAS;
            return;
        }
        this.dateConstant = whatEventOfDay(convertDayToDayOfWeek(day));
    }

    private boolean isChristmas(int day) {
        return day == 25;
    }

    private DayOfWeek convertDayToDayOfWeek(int day) {
        LocalDate localDate = LocalDate.of(2023, 12, day);
        return localDate.getDayOfWeek();
    }

    private DateConstant whatEventOfDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return DateConstant.WEEKEND;
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            return DateConstant.SUNDAY;
        } return DateConstant.WEEKDAY;
    }
}
