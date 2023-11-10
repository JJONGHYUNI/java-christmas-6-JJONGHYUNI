package christmas.model.menu;

import christmas.model.event.Event;
import christmas.model.event.constant.EventConstants;
import christmas.model.menu.constant.MenuItem;

public class MainMenu extends Menu implements Event {
    public MainMenu(MenuItem menuItem, int count) {
        super(menuItem, count);
    }

    @Override
    public int salePrice() {
        return getCount() * EventConstants.WEEKEND_EVENT_SALE_PRICE.getSalePrice();
    }
}
