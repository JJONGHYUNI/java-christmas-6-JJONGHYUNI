package christmas.model.date.constant;

public enum DayConstant {
    CURRENT_YEAR(2023),
    CURRENT_MONTH(12),
    CHRISTMAS_DAY(25),
    DAY_MIN_LENGTH(1),
    DAY_MAX_LENGTH(31);

    private final int number;

    DayConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
