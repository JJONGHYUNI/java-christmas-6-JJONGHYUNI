package christmas.model.menu;

import christmas.model.menu.constant.MenuItem;

abstract class Menu {
    private final MenuItem menuItem;
    private final int count;

    public Menu(String menuName, int count) {
        this.menuItem = MenuItem.findOrderMenu(menuName);
        this.count = count;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getCount() {
        return count;
    }
}
