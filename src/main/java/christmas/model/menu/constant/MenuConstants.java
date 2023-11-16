package christmas.model.menu.constant;

public enum MenuConstants {
    MENU_PAIR_LENGTH(2),
    MENU_NAME_INDEX(0),
    MENU_COUNT_INDEX(1),
    MENU_COUNT_MIN_RANGE(1);

    private final int number;

    MenuConstants(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
