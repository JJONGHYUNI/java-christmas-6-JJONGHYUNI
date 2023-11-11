package christmas.model.event;

import christmas.model.event.constant.EventConstants;

import java.util.HashMap;
import java.util.Map;

public class WeekendEvent implements Event{
    @Override
    public Map<String, Integer> salePrice(int count) {
        Map<String, Integer> events = new HashMap<>();
        events.put(EventConstants.WEEKEND_EVENT_SALE_PRICE.getSaleTitle(), EventConstants.WEEKDAY_EVENT_SALE_PRICE.getSalePrice() * count);
        return events;
    }
}
