package christmas.model.day.constant;

public enum Calendar {
    WEEKEND(false, true, false),
    WEEKDAY(true, false, false),
    SUNDAY(true, false, true),
    CHRISTMAS(true, false, true);

    private final boolean isWeekDay;
    private final boolean isWeekend;
    private final boolean isStarMarking;

    Calendar(boolean isWeekDay, boolean isWeekend, boolean isStarMarking) {
        this.isWeekDay = isWeekDay;
        this.isWeekend = isWeekend;
        this.isStarMarking = isStarMarking;
    }

    public boolean isWeekDay() {
        return isWeekDay;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public boolean isStarMarking() {
        return isStarMarking;
    }
}
