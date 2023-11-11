package christmas.model.event;

import christmas.model.event.constant.EventConstants;
import christmas.model.menu.constant.MenuCategory;

import java.util.HashMap;
import java.util.Map;

public class WeekendEvent implements Event{
    @Override
    public Map<String, Integer> salePrice(Map<String, Integer> eachCategoryCounts) {
        Map<String, Integer> events = new HashMap<>();
        events.put(EventConstants.WEEKEND_EVENT_SALE_PRICE.getSaleTitle(),
                EventConstants.WEEKEND_EVENT_SALE_PRICE.getSalePrice() * eachCategoryCounts.get(MenuCategory.MAIN.getCategoryName()));
        return events;
    }
}
