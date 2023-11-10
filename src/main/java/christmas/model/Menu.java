package christmas.model;

import christmas.model.constant.MenuItem;

abstract class Menu {
    private final MenuItem menuItem;

    public Menu(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
