package christmas.model.order;

import christmas.model.menu.Appitizer;
import christmas.model.menu.Dessert;
import christmas.model.menu.Drink;
import christmas.model.menu.MainMenu;
import christmas.model.menu.constant.MenuCategory;
import christmas.model.menu.constant.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    private final List<Object> menus = new ArrayList<>();

    public Order(String orderInput) {
        String[] orderInputs = splitEachOrder(orderInput);
        Arrays.stream(orderInputs).forEach(input -> create(input));
    }

    private void create(String orderMenu) {
        String[] menuAndCount = splitMenuAndCount(orderMenu);
        validateMenuAndCountRange(menuAndCount);
        MenuItem menuItem = MenuItem.findOrderMenu(menuAndCount[0]);
        createAppitizer(menuItem, menuAndCount[1]);
        createMainMenu(menuItem, menuAndCount[1]);
        createDessert(menuItem, menuAndCount[1]);
        createDrink(menuItem, menuAndCount[1]);
    }

    private void validateMenuAndCountRange(String[] menuAndCount) {
        if(menuAndCount.length != 2) {
            throw new IllegalArgumentException();
        }
    }

    private void createAppitizer(MenuItem menuItem, String count) {
        if(menuItem.getCategory().equals(MenuCategory.APPITIZER.getCategoryName())) {
            menus.add(new Appitizer(menuItem.getMenuName(), menuItem.getPrice(), count));
        }
    }

    private void createMainMenu(MenuItem menuItem, String count) {
        if(menuItem.getCategory().equals(MenuCategory.MAIN.getCategoryName())) {
            menus.add(new MainMenu(menuItem.getMenuName(), menuItem.getPrice(), count));
        }
    }

    private void createDessert(MenuItem menuItem, String count) {
        if(menuItem.getCategory().equals(MenuCategory.DESSERT.getCategoryName())) {
            menus.add(new Dessert(menuItem.getMenuName(), menuItem.getPrice(), count));
        }
    }

    private void createDrink(MenuItem menuItem, String count) {
        if(menuItem.getCategory().equals(MenuCategory.DRINK.getCategoryName())) {
            menus.add(new Drink(menuItem.getMenuName(), menuItem.getPrice(), count));
        }
    }

    private static String[] splitEachOrder(String orderInput) {
        return orderInput.split(",");
    }

    private static String[] splitMenuAndCount(String orderMenu) {
        return orderMenu.split("-");
    }
}
