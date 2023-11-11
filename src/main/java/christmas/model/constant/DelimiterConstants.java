package christmas.model.constant;

public enum DelimiterConstants {
    ORDER_SPLIT_DELIMITER(","),
    MENU_PAIR_SPLIT_DELIMITER("-");

    private final String delimiter;

    DelimiterConstants(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
