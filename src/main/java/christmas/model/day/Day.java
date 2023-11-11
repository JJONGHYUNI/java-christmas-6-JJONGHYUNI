package christmas.model.day;

import christmas.model.day.constant.Calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.model.day.constant.Calendar.*;
import static christmas.model.day.constant.DayConstant.*;

public class Day {
    private final int day;
    private final Calendar calendar;

    public Day(String date) {
        int checkDay = validateDateIsNumeric(date);
        validate(checkDay);
        this.day = checkDay;
        if (isChristmas(checkDay)) {
            this.calendar = CHRISTMAS;
            return;
        }
        this.calendar = whatEventOfDay(convertDayToDayOfWeek(checkDay));
    }

    private void validate(int day) {
        if (day > DAY_MAX_LENGTH.getNumber() || day < DAY_MIN_LENGTH.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    private int validateDateIsNumeric(String date) {
        try {
            return Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isChristmas(int day) {
        return day == CHRISTMAS_DAY.getNumber();
    }

    private DayOfWeek convertDayToDayOfWeek(int day) {
        LocalDate localDate = LocalDate.of(CURRENT_YEAR.getNumber(), CURRENT_MONTH.getNumber(), day);
        return localDate.getDayOfWeek();
    }

    private Calendar whatEventOfDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return WEEKEND;
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            return SUNDAY;
        } return WEEKDAY;
    }
}
