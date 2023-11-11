package christmas.model.order;

import christmas.model.constant.DelimiterConstants;
import christmas.model.menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final List<Menu> menus = new ArrayList<>();

    public Order(String orders) {
        validateOrder(orders);
        String[] menuInfos = splitOrder(orders);
        Arrays.stream(menuInfos)
                .forEach(menuInfo -> menus.add(new Menu(menuInfo)));
    }

    private void validateOrder(String order) {
        if(order.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private String[] splitOrder(String order) {
        return order.split(DelimiterConstants.ORDER_SPLIT_DELIMITER.getDelimiter());
    }
}
