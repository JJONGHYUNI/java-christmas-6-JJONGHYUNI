package christmas.service;

import christmas.model.dto.RewardInfoDto;
import christmas.model.reward.Reward;
import christmas.model.reward.Rewards;

import java.util.List;
import java.util.Map;

public class RewardsService {
    private final RewardService rewardService = new RewardService();

    public Rewards createRewards(Map<String, Integer> dDayReward, Map<String, Integer> discountReward, Map<String, Integer> giftReward) {
        Rewards rewards = new Rewards();
        dDayReward.entrySet().forEach(rewardInfo -> addReward(rewards, rewardInfo));
        discountReward.entrySet().forEach(rewardInfo -> addReward(rewards, rewardInfo));
        giftReward.entrySet().forEach(rewardInfo -> addReward(rewards, rewardInfo));
        return rewards;
    }

    private static void addReward(Rewards rewards, Map.Entry<String, Integer> rewardInfo) {
        Reward reward = new Reward(rewardInfo);
        rewards.addReward(reward);
    }

    public List<RewardInfoDto> getRewards(Rewards rewards) {
        return rewards.getRewards()
                .stream()
                .map(rewardService::getRewardInfo)
                .toList();
    }
}
