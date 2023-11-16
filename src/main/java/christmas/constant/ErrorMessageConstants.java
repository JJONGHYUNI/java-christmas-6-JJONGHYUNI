package christmas.constant;

public enum ErrorMessageConstants {
    DATE_EXCEPTION_MESSAGE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    MENU_EXCEPTION_MESSAGE("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    ErrorMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
