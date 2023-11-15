package christmas.model.event;

import christmas.model.dto.RewardInfoDto;

import java.util.List;
import java.util.Map;

public interface Event {
    List<RewardInfoDto> salePrice(Map<String, Integer> eachCategoryCounts);
}
