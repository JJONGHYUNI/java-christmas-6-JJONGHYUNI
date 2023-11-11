package christmas.model.event;

import christmas.model.event.constant.EventConstants;

import java.util.HashMap;
import java.util.Map;

public class SundayEvent implements Event{
    @Override
    public Map<String, Integer> salePrice(int count) {
        Map<String, Integer> events = new HashMap<>();
        events.put(EventConstants.WEEKDAY_EVENT_SALE_PRICE.getSaleTitle(), EventConstants.WEEKDAY_EVENT_SALE_PRICE.getSalePrice() * count);
        events.put(EventConstants.SPECIAL_EVENT_SALE_PRICE.getSaleTitle(), EventConstants.SPECIAL_EVENT_SALE_PRICE.getSalePrice());
        return events;
    }
}
