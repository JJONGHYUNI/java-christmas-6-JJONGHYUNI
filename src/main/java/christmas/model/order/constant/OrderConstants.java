package christmas.model.order.constant;

public enum OrderConstants {
    MENU_COUNT_INITIAL_VALUE(0),
    MENU_COUNT_ADD_VALUE(1),
    TOTAL_COUNT_MAX_RANGE(20);

    private final int number;

    OrderConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
