package christmas.model.event.constant;

public enum EventConstants {
    CHRISTMAS_D_DAY_DEFAULT_SALE_PRICE("크리스마스 디데이 할인 : ", -1000),
    CHRISTMAS_D_DAY_ADD_SALE_PRICE("크리스마스 디데이 추가 할인 : ", -100),
    WEEKDAY_EVENT_SALE_PRICE("평일 할인: ", -2023),
    WEEKEND_EVENT_SALE_PRICE("주말 할인: ", -2023),
    SPECIAL_EVENT_SALE_PRICE("특별 할인: ", -1000),
    GIFT_EVENT_PRICE("증정 이벤트: ", -25000),
    GIFT_EVENT_ITEM("샴페인", 1),
    STAR_BADGE_INFORMATION("별", 5000),
    TREE_BADGE_INFORMATION("트리", 10000),
    SANTA_BADGE_INFORMATION("산타", 20000),
    NOTHING_BADGE_INFORMATION("없음", 0);

    private final String Title;
    private final int Price;

    EventConstants(String title, int number) {
        this.Title = title;
        this.Price = number;
    }

    public int getPrice() {
        return Price;
    }

    public String getTitle() {
        return Title;
    }
}
