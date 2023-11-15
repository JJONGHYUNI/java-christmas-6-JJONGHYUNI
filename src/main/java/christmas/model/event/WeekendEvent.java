package christmas.model.event;

import christmas.model.dto.RewardInfoDto;
import christmas.model.event.constant.EventConstants;
import christmas.model.menu.constant.MenuCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static christmas.model.event.constant.EventConstants.WEEKEND_EVENT_SALE_PRICE;

public class WeekendEvent implements Event{
    @Override
    public List<RewardInfoDto> salePrice(Map<String, Integer> eachCategoryCounts) {
        List<RewardInfoDto> rewardInfoDtos = new ArrayList<>();
        if (isContainMainCategory(eachCategoryCounts)) {
            rewardInfoDtos.add(RewardInfoDto.create(WEEKEND_EVENT_SALE_PRICE.getSaleTitle(),
                    WEEKEND_EVENT_SALE_PRICE.getSalePrice() * eachCategoryCounts.get(MenuCategory.MAIN.getCategoryName())));
        }
        return rewardInfoDtos;
    }
}
