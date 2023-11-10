package christmas.model.menu;

import christmas.model.menu.constant.MenuItem;

abstract class Menu {
    private final MenuItem menuItem;
    private final int count;

    public Menu(MenuItem menuItem, int count) {
        this.menuItem = menuItem;
        this.count = count;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getCount() {
        return count;
    }
}
