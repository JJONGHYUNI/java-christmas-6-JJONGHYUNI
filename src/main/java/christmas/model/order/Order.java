package christmas.model.order;

import christmas.model.constant.DelimiterConstants;
import christmas.model.event.Event;
import christmas.model.menu.Menu;
import christmas.model.menu.constant.MenuItem;
import christmas.model.order.constant.OrderConstants;

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
        validateMenuSize();
        this.event = event;
    }

    //각 카테고리별 메뉴 개수를 구하는 메소드
    private Map<String, Integer> getEachMenuCount() {
        Map<String, Integer> eachMenuCounts = new HashMap<>();
        menus.stream().forEach(menu -> {
            String category = menu.getMenuItem().getCategory();
            eachMenuCounts
                    .put(category, eachMenuCounts.getOrDefault(category, OrderConstants.MENU_COUNT_INITIAL_VALUE.getNumber()) + OrderConstants.MENU_COUNT_ADD_VALUE.getNumber());
        });
        return eachMenuCounts;
    }

    private void validateOrder(String order) {
        if(order.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    //메뉴가 20개 이상이면 예외 발생
    private void validateMenuSize() {
        if(menus.stream().map(Menu::getCount).mapToInt(Integer::intValue).sum() > OrderConstants.TOTAL_COUNT_MAX_RANGE.getNumber()) {
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
