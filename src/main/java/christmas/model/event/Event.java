package christmas.model.event;

import java.util.HashMap;
import java.util.Map;

public class Event {
    private final int totalPrice;
    private final Map<String, Integer> categoryCounts = new HashMap<>();

    public Event(String category, int count, int totalPrice) {
        this.totalPrice = totalPrice;
        categoryCounts.put(category,count);
    }
}
