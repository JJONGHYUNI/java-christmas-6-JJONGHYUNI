package christmas.view.constant;

public enum OutputMessageConstants {
    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PREVIEW_EVENT_MESSAGE("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

    private final String message;

    OutputMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
