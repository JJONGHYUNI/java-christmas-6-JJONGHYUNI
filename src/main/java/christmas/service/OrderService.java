package christmas.service;

import christmas.model.dto.MenuInfoDto;
import christmas.model.order.Order;

import java.util.List;

public class OrderService {
    private final MenuService menuService = new MenuService();

    public List<MenuInfoDto> getOrderMenuInfos(Order order) {
        return order.getMenus()
                .stream()
                .map(menuService::getMenuInfo)
                .toList();
    }
}
