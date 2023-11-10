package christmas.model.day;

import christmas.model.day.constant.Calendar;
import christmas.model.day.constant.DayConstant;
import christmas.model.event.Event;
import christmas.model.event.constant.EventConstants;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.model.day.constant.Calendar.*;
import static christmas.model.day.constant.DayConstant.*;
import static christmas.model.event.constant.EventConstants.*;

public class Day implements Event {
    private final int day;
    private final Calendar calendar;

    public Day(int day) {
        validate(day);
        this.day = day;
        if(isChristmas(day)) {
            this.calendar = CHRISTMAS;
            return;
        }
        this.calendar = whatEventOfDay(convertDayToDayOfWeek(day));
    }

    private void validate(int day) {
        if (day > DAY_MAX_LENGTH.getNumber() || day < DAY_MIN_LENGTH.getNumber()) {
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

    @Override
    public int salePrice() {
        return CHRISTMAS_D_DAY_DEFAULT_SALE_PRICE.getSalePrice() +
                CHRISTMAS_D_DAY_ADD_SALE_PRICE.getSalePrice();
    }
}
