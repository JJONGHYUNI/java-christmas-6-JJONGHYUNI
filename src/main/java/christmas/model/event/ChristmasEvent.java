package christmas.model.event;

import christmas.model.dto.RewardInfoDto;
import christmas.model.event.constant.EventConstants;
import christmas.model.menu.constant.MenuCategory;
import christmas.model.reward.Reward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.model.event.constant.EventConstants.*;

public class ChristmasEvent implements Event{
    @Override
    public List<RewardInfoDto> salePrice(Map<String, Integer> eachCategoryCounts) {
        List<RewardInfoDto> rewardInfoDtos = new ArrayList<>();
        if (isContainDessertCategory(eachCategoryCounts)) {
            rewardInfoDtos.add(RewardInfoDto.create(WEEKDAY_EVENT_SALE_PRICE.getSaleTitle(),
                    WEEKDAY_EVENT_SALE_PRICE.getSalePrice() * eachCategoryCounts.get(MenuCategory.DESSERT.getCategoryName())));
            rewardInfoDtos.add(RewardInfoDto.create(SPECIAL_EVENT_SALE_PRICE.getSaleTitle(), SPECIAL_EVENT_SALE_PRICE.getSalePrice()));
        }
        return rewardInfoDtos;
    }
}
