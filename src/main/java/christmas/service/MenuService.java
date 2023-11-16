package christmas.service;

import christmas.model.dto.MenuInfoDto;
import christmas.model.menu.Menu;

public class MenuService {
    public MenuInfoDto getMenuInfo(Menu menu) {
        return MenuInfoDto.create(menu.getMenuItem().getMenuName(), menu.getCount());
    }
}
