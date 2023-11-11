package christmas.model.order;

import christmas.model.menu.WootecoMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final List<WootecoMenu> wootecoMenus = new ArrayList<>();

    public Order(String order) {
        validateOrder(order);
        String[] menuInfos = splitOrder(order);
        Arrays.stream(menuInfos)
                .forEach(menuInfo -> wootecoMenus.add(new WootecoMenu(menuInfo)));
    }

    private void validateOrder(String order) {
        if(order.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private String[] splitOrder(String order) {
        return order.split(",");
    }
}
