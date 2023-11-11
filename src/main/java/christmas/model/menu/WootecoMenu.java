package christmas.model.menu;

import christmas.model.menu.constant.WootecoMenuItem;

public class WootecoMenu {
    private final WootecoMenuItem wootecoMenuItem;
    private final int count;

    //orderMenu = 양송이수프-1
    public WootecoMenu(String orderInput) {
        String[] menuNameAndCount = splitOrderInput(orderInput);
        validateOrderLength(menuNameAndCount);
        this.wootecoMenuItem = WootecoMenuItem.findOrderMenu(menuNameAndCount[0]);
        int menuCount = validateCount(menuNameAndCount[1]);
        this.count = validateCountRange(menuCount);
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

    private int validateCountRange(int count) {
        if(count < 1) {
            throw new IllegalArgumentException();
        }
        return count;
    }

    public WootecoMenuItem getMenuItem() {
        return wootecoMenuItem;
    }

    public int getCount() {
        return count;
    }
}
