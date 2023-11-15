package christmas.model.menu;

import christmas.constant.DelimiterConstants;
import christmas.model.menu.constant.MenuConstants;
import christmas.model.menu.constant.MenuItem;

import static christmas.constant.ErrorMessageConstants.*;

public class Menu {
    private final MenuItem menuItem;
    private final int count;

    //orderMenu = 양송이수프-1
    public Menu(String menuInfo) {
        String[] menuNameAndCount = splitMenuInfo(menuInfo);
        validateOrderLength(menuNameAndCount);
        this.menuItem = MenuItem.findOrderMenu(menuNameAndCount[MenuConstants.MENU_NAME_INDEX.getNumber()]);
        int menuCount = validateCount(menuNameAndCount[MenuConstants.MENU_COUNT_INDEX.getNumber()]);
        this.count = validateCountRange(menuCount);
    }

    private static String[] splitMenuInfo(String orderInput) {
        return orderInput.split(DelimiterConstants.MENU_PAIR_SPLIT_DELIMITER.getDelimiter());
    }

    private void validateOrderLength(String[] menuNameAndCount) {
        if(menuNameAndCount.length != MenuConstants.MENU_PAIR_LENGTH.getNumber()) {
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private int validateCount(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private int validateCountRange(int count) {
        if(count < MenuConstants.MENU_COUNT_MIN_RANGE.getNumber()) {
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE.getMessage());
        }
        return count;
    }

    public int getMenuPrice() {
        return menuItem.getPrice() * count;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getCount() {
        return count;
    }
}
