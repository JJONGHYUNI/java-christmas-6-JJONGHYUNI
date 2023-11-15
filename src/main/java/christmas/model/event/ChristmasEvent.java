package christmas.model.event;

import christmas.model.dto.RewardInfoDto;
import christmas.model.menu.constant.MenuCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static christmas.model.event.constant.EventConstants.*;

public class ChristmasEvent implements Event{
    @Override
    public List<RewardInfoDto> salePrice(Map<String, Integer> eachCategoryCounts) {
        List<RewardInfoDto> rewardInfoDtos = new ArrayList<>();
        if (isContainDessertCategory(eachCategoryCounts)) {
            rewardInfoDtos.add(RewardInfoDto.create(WEEKDAY_EVENT_SALE_PRICE.getTitle(),
                    WEEKDAY_EVENT_SALE_PRICE.getPrice() * eachCategoryCounts.get(MenuCategory.DESSERT.getCategoryName())));
            rewardInfoDtos.add(RewardInfoDto.create(SPECIAL_EVENT_SALE_PRICE.getTitle(), SPECIAL_EVENT_SALE_PRICE.getPrice()));
        }
        return rewardInfoDtos;
    }
}
