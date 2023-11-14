package christmas.model.event.constant;

public enum EventConstants {
    CHRISTMAS_D_DAY_DEFAULT_SALE_PRICE("크리스마스 디데이 할인 : ", -1000),
    CHRISTMAS_D_DAY_ADD_SALE_PRICE("크리스마스 디데이 추가 할인 : ", -100),
    WEEKDAY_EVENT_SALE_PRICE("평일 할인 : ", -2023),
    WEEKEND_EVENT_SALE_PRICE("주말 할인 : ", -2023),
    SPECIAL_EVENT_SALE_PRICE("특별 할인 : ", -1000),
    GIFT_EVENT_PRICE("증정 할인 : ", -25000),
    GIFT_EVENT_ITEM("샴페인", 1);

    private final String saleTitle;
    private final int salePrice;

    EventConstants(String title, int number) {
        this.saleTitle = title;
        this.salePrice = number;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public String getSaleTitle() {
        return saleTitle;
    }
}
