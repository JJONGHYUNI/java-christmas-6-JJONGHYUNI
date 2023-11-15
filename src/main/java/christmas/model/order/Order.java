package christmas.model.order;

import christmas.constant.DelimiterConstants;
import christmas.model.dto.RewardInfoDto;
import christmas.model.event.Event;
import christmas.model.event.constant.EventRule;
import christmas.model.menu.Menu;
import christmas.model.menu.constant.MenuCategory;
import christmas.model.menu.constant.MenuItem;
import christmas.model.order.constant.OrderConstants;

import java.util.*;

import static christmas.constant.ErrorMessageConstants.*;
import static christmas.model.event.constant.EventConstants.*;

public class Order {
    private final List<Menu> menus = new ArrayList<>();
    private final Event event;

    public Order(String orders, Event event) {
        validateOrder(orders);
        String[] menuInfos = splitOrder(orders);
        Arrays.stream(menuInfos)
                .forEach(menuInfo -> menus.add(new Menu(menuInfo)));
        validateDuplicate();
        validateMenuSize();
        validateMenuConstitude();
        this.event = event;
    }

    //각 카테고리별 메뉴 개수를 구하는 메소드
    private Map<String, Integer> getEachMenuCount() {
        Map<String, Integer> eachMenuCounts = new HashMap<>();
        menus.stream().forEach(menu -> {
            String category = menu.getMenuItem().getCategory();
            eachMenuCounts
                    .put(category, eachMenuCounts.getOrDefault(category, OrderConstants.MENU_COUNT_INITIAL_VALUE.getNumber()) + menu.getCount());
        });
        return eachMenuCounts;
    }

    private void validateOrder(String order) {
        if(order.isEmpty()){
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE.getMessage());
        }
    }

    //메뉴가 20개 이상이면 예외 발생
    private void validateMenuSize() {
        if(menus.stream().map(Menu::getCount).mapToInt(Integer::intValue).sum() > OrderConstants.TOTAL_COUNT_MAX_RANGE.getNumber()) {
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void validateDuplicate() {
        List<MenuItem> menuItems = menus.stream().map(Menu::getMenuItem).toList();
        if (menuItems.size() != new HashSet<>(menuItems).size()) {
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void validateMenuConstitude() {
        Set<String> categorys = new HashSet<>(menus.stream().map(menu -> menu.getMenuItem().getCategory()).toList());
        if (categorys.size() == OrderConstants.CATEGORY_VALID_VALUE.getNumber() && categorys.contains(MenuCategory.DRINK.getCategoryName())) {
            throw new IllegalArgumentException(MENU_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private String[] splitOrder(String order) {
        return order.split(DelimiterConstants.ORDER_SPLIT_DELIMITER.getDelimiter());
    }

    public List<RewardInfoDto> findReward() {
        return event.salePrice(getEachMenuCount());
    }

    public List<RewardInfoDto> findGiftReward() {
        List<RewardInfoDto> rewardInfoDtos = new ArrayList<>();
        if(isGiftEventApply()) {
            rewardInfoDtos.add(RewardInfoDto.create(
                    GIFT_EVENT_PRICE.getTitle(), GIFT_EVENT_PRICE.getPrice()
            ));
        }
        return rewardInfoDtos;
    }

    public int calculateTotalPrice() {
        return menus.stream().mapToInt(Menu::calculateMenuPrice).sum();
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public boolean isGiftEventApply() {
        return calculateTotalPrice() > EventRule.GIFT_EVENT_APPLY_AMOUNT.getAmount();
    }

    public boolean isEventApply() {
        return event.isAppliedEvent(calculateTotalPrice());
    }
}
