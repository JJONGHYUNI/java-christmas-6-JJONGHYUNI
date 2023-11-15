package christmas.model.event.constant;

public enum EventRule {
    GIFT_EVENT_APPLY_AMOUNT(120000),
    EVENT_APPLY_AMOUNT(10000);

    private final int amount;

    EventRule(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
