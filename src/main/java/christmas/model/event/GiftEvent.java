package christmas.model.event;

import christmas.model.event.constant.EventConstants;
import christmas.model.event.constant.EventRule;

import java.util.Map;

public class GiftEvent {
    public Map<String, Integer> receiveGiftItem(int totalPrice) {
        if (isGiftEventApplied(totalPrice)) {
            return Map.of(EventConstants.GIFT_EVENT_ITEM.getSaleTitle(), EventConstants.GIFT_EVENT_ITEM.getSalePrice());
        }
        return receiveNotAppliedEvent();
    }

    public Map<String, Integer> receiveGiftPrice(int totalPrice) {
        if(isGiftEventApplied(totalPrice)) {
            return Map.of(EventConstants.GIFT_EVENT_PRICE.getSaleTitle(), EventConstants.GIFT_EVENT_PRICE.getSalePrice());
        }
        return receiveNotAppliedEvent();
    }

    private static boolean isGiftEventApplied(int totalPrice) {
        return totalPrice >= EventRule.GIFT_EVENT_APPLY_AMOUNT.getAmount();
    }

    private static Map<String,Integer> receiveNotAppliedEvent() {
        return Map.of(EventConstants.DISCOUNT_NOT_APLLIED.getSaleTitle(), EventConstants.DISCOUNT_NOT_APLLIED.getSalePrice());
    }
}
