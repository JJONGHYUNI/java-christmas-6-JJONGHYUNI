package christmas.model.event;

import christmas.model.menu.Menu;

import java.util.List;
import java.util.Map;

public interface Event {
    Map<String, Integer> salePrice(Map<String, Integer> eachCategoryCounts);
}
