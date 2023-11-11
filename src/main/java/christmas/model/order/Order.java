package christmas.model.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Object> menus = new ArrayList<>();

    public Order(String orderInput) {
        String[] order = splitEachOrder(orderInput);

    }

    private static String[] splitEachOrder(String orderInput) {
        return orderInput.split(",");
    }
}
