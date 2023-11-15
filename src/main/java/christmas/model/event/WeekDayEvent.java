package christmas.model.event;

import christmas.model.dto.RewardInfoDto;
import christmas.model.event.constant.EventConstants;
import christmas.model.menu.constant.MenuCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static christmas.model.event.constant.EventConstants.WEEKDAY_EVENT_SALE_PRICE;

public class WeekDayEvent implements Event{
    @Override
    public List<RewardInfoDto> salePrice(Map<String, Integer> eachCategoryCounts) {
        List<RewardInfoDto> rewardInfoDtos = new ArrayList<>();
        if (isContainDessertCategory(eachCategoryCounts)) {
            rewardInfoDtos.add(RewardInfoDto.create(WEEKDAY_EVENT_SALE_PRICE.getSaleTitle(),
                    WEEKDAY_EVENT_SALE_PRICE.getSalePrice() * eachCategoryCounts.get(MenuCategory.DESSERT.getCategoryName())));
        }
        return rewardInfoDtos;
    }
}
