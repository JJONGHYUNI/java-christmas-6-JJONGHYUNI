package christmas.model.day;

import christmas.model.day.constant.Calendar;
import christmas.model.dto.RewardInfoDto;
import christmas.model.event.constant.EventConstants;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.model.day.constant.Calendar.*;
import static christmas.model.day.constant.DayConstant.*;
import static christmas.model.event.constant.EventConstants.*;

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

    public int getDay() {
        return day;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public List<RewardInfoDto> receiveDdayReward() {
        List<RewardInfoDto> rewardInfoDtos = new ArrayList<>();
        if(isAppliedDdayEvent()) {
            rewardInfoDtos.add(RewardInfoDto.create(
                    CHRISTMAS_D_DAY_DEFAULT_SALE_PRICE.getSaleTitle(),
                    CHRISTMAS_D_DAY_DEFAULT_SALE_PRICE.getSalePrice() + CHRISTMAS_D_DAY_ADD_SALE_PRICE.getSalePrice() * (day - 1)
            ));
        }
        return rewardInfoDtos;
    }

    private boolean isAppliedDdayEvent() {
        return day <= CHRISTMAS_DAY.getNumber();
    }
}
