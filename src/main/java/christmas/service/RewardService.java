package christmas.service;

import christmas.model.dto.RewardInfoDto;
import christmas.model.reward.Reward;

public class RewardService {
    public RewardInfoDto getRewardInfo(Reward reward) {
        return RewardInfoDto.create(reward.getTitle(), reward.getBenefit());
    }
}
