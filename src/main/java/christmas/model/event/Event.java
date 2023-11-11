package christmas.model.event;

import java.util.Map;

public interface Event {
    Map<String, Integer> salePrice(int count);
}
