package christmas.model.event;

import christmas.model.dto.RewardInfoDto;
import christmas.model.event.constant.EventRule;
import christmas.model.menu.constant.MenuCategory;

import java.util.List;
import java.util.Map;

public interface Event {
    List<RewardInfoDto> salePrice(Map<String, Integer> eachCategoryCounts);

    default boolean isAppliedEvent(int totalPrice) {
        return totalPrice < EventRule.EVENT_APPLY_AMOUNT.getAmount();
    }

    default boolean isContainMainCategory(Map<String, Integer> eachCategoryCounts) {
        return eachCategoryCounts.containsKey(MenuCategory.MAIN.getCategoryName());
    }

    default boolean isContainDessertCategory(Map<String, Integer> eachCategoryCounts) {
        return eachCategoryCounts.containsKey(MenuCategory.DESSERT.getCategoryName());
    }
}
