package christmas.view.constant;

public enum OutputMessageConstants {
    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PREVIEW_EVENT_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_MESSAGE("<주문 메뉴>"),
    MENU_INFO_MESSAGE("%s %d개"),
    TOTAL_AMOUNT_BEFORE_DISCOUNT_NOTICE_MESSAGE("<할인 전 총주문 금액>"),
    TOTAL_AMOUNT_BEFORE_DISCOUNT_MESSAGE("%,d원"),
    GIFT_ITEM_NOTICE_MESSAGE("<증정 메뉴>"),
    GIFT_ITEM_MESSAGE("%s %d개"),
    NOTHING_MESSAGE("없음"),
    REWARD_INFO_NOTICE_MESSAGE("<혜택 내역>"),
    REWARD_INFO_MESSAGE("%s: %,d원");

    private final String message;

    OutputMessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
