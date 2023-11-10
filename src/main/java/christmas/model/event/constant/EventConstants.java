package christmas.model.event.constant;

public enum EventConstants {
    CHRISTMAS_EVENT_SALE_PRICE(-1000),
    WEEKDAY_EVENT_SALE_PRICE(-2023),
    WEEKEND_EVENT_SALE_PRICE(-2023),
    SPECIAL_EVENT_SALE_PRICE(-1000),
    GIFT_EVENT_PRICE(-25000);

    private final int salePrice;

    EventConstants(int number) {
        this.salePrice = number;
    }

    public int getSalePrice() {
        return salePrice;
    }
}
