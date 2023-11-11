package christmas.model.order;

import christmas.model.constant.DelimiterConstants;
import christmas.model.event.Event;
import christmas.model.menu.Menu;
import christmas.model.menu.constant.MenuItem;

import java.util.*;

public class Order {
    private final List<Menu> menus = new ArrayList<>();
    private final Event event;

    public Order(String orders, Event event) {
        validateOrder(orders);
        String[] menuInfos = splitOrder(orders);
        Arrays.stream(menuInfos)
                .forEach(menuInfo -> menus.add(new Menu(menuInfo)));
        validateDuplicate();
        this.event = event;
    }

    private void validateOrder(String order) {
        if(order.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate() {
        List<MenuItem> menuItems = menus.stream().map(Menu::getMenuItem).toList();
        if (menuItems.size() != new HashSet<>(menuItems).size()) {
            throw new IllegalArgumentException();
        }
    }

    private String[] splitOrder(String order) {
        return order.split(DelimiterConstants.ORDER_SPLIT_DELIMITER.getDelimiter());
    }
}
