package christmas.service;

import christmas.model.dto.RewardInfoDto;
import christmas.model.reward.Reward;
import christmas.model.reward.Rewards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RewardsService {
    private final RewardService rewardService = new RewardService();

    public Rewards createRewards(List<RewardInfoDto> dDayRewards, List<RewardInfoDto> discountRewards, List<RewardInfoDto> giftRewards, boolean isApplied) {
        Rewards rewards = new Rewards();
        if(isApplied) {
            return rewards;
        }
        List<RewardInfoDto> rewardInfoDtos = new ArrayList<>();
        rewardInfoDtos.addAll(dDayRewards);
        rewardInfoDtos.addAll(discountRewards);
        rewardInfoDtos.addAll(giftRewards);
        rewardInfoDtos.forEach(rewardInfoDto -> addReward(rewards, rewardInfoDto));
        return rewards;
    }

    private static void addReward(Rewards rewards, RewardInfoDto rewardInfoDto) {
        Reward reward = new Reward(rewardInfoDto.getRewardTitle(), rewardInfoDto.getRewardPrice());
        rewards.addReward(reward);
    }

    public List<RewardInfoDto> getRewards(Rewards rewards) {
        if (isEmptyReward(rewards)) {
            return new ArrayList<>(Collections.emptyList());
        }
        return rewards.getRewards()
                .stream()
                .map(rewardService::getRewardInfo)
                .toList();
    }

    private boolean isEmptyReward(Rewards rewards) {
        return rewards.getRewards().isEmpty();
    }
}
