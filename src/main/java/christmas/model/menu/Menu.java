package christmas.model.menu;

import christmas.model.menu.constant.MenuItem;

abstract class Menu {
    private final MenuItem menuItem;
    private final int count;

    public Menu(String order) {
        String[] menuNameAndCount = splitMenuNameAndCount(order);
        validateSize(menuNameAndCount);
        validateCount(menuNameAndCount[1]);
        this.menuItem = MenuItem.findOrderMenu(menuNameAndCount[0]);
        this.count = Integer.parseInt(menuNameAndCount[1]);
    }

    private static String[] splitMenuNameAndCount(String order) {
        return order.split("-");
    }

    private void validateSize(String[] menuNameAndCount) {
        if(menuNameAndCount.length != 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCount(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getCount() {
        return count;
    }
}
