package christmas.model.menu;

import christmas.model.menu.constant.MenuItem;

class Menu {
    private final MenuItem menuItem;
    private final int count;

    //orderMenu = 양송이수프-1
    public Menu(String orderInput) {
        String[] menuNameAndCount = splitOrderInput(orderInput);
        validateOrderLength(menuNameAndCount);
        this.menuItem = MenuItem.findOrderMenu(menuNameAndCount[0]);
        validateCount(menuNameAndCount[1]);
        this.count = validateCount(menuNameAndCount[1]);
    }

    private static String[] splitOrderInput(String orderInput) {
        return orderInput.split("-");
    }

    private void validateOrderLength(String[] menuNameAndCount) {
        if(menuNameAndCount.length != 2) {
            throw new IllegalArgumentException();
        }
    }

    private int validateCount(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCountRange(int count) {
        if(count < 1) {
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
