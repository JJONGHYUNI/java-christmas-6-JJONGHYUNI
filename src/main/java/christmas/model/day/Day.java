package christmas.model.day;

import christmas.model.day.constant.Calendar;
import christmas.model.day.constant.DayConstant;
import christmas.model.event.Event;
import christmas.model.event.constant.EventConstants;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Day implements Event {
    private final int day;
    private final Calendar calendar;

    public Day(int day) {
        validate(day);
        this.day = day;
        if(isChristmas(day)) {
            this.calendar = Calendar.CHRISTMAS;
            return;
        }
        this.calendar = whatEventOfDay(convertDayToDayOfWeek(day));
    }

    private void validate(int day) {
        if (day > DayConstant.DAY_MAX_LENGTH.getNumber() || day < DayConstant.DAY_MIN_LENGTH.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
    private boolean isChristmas(int day) {
        return day == DayConstant.CHRISTMAS_DAY.getNumber();
    }

    private DayOfWeek convertDayToDayOfWeek(int day) {
        LocalDate localDate = LocalDate.of(DayConstant.CURRENT_YEAR.getNumber(), DayConstant.CURRENT_MONTH.getNumber(), day);
        return localDate.getDayOfWeek();
    }

    private Calendar whatEventOfDay(DayOfWeek dayOfWeek) {
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return Calendar.WEEKEND;
        } else if (dayOfWeek == DayOfWeek.SUNDAY) {
            return Calendar.SUNDAY;
        } return Calendar.WEEKDAY;
    }

    @Override
    public int salePrice() {
        return EventConstants.CHRISTMAS_D_DAY_SALE_PRICE.getSalePrice() - (day * 100);
    }
}
